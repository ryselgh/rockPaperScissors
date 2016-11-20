package com.bytecode.logic;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Questa classe gestisce l'intera logica di gioco,<br>
 * per semplicità racchiude anche una CLI essenziale
 */
public class Gioco {

	private final Scanner scanner;
	private final static int ROUNDS = 3;
	private boolean IA;
	private Giocatore[] giocatori;

	/**
	 * Inizializza e avvia il gioco
	 * @param input rappresenta un input stream di bytes, in questo caso è usato per interagire con l'utente.
	 * @throws NullPointerException se l'argomento è nullo
	 */
	public Gioco(InputStream input) {
		if (input == null)
	        throw new NullPointerException("L'argomento non può essere nullo.");
		this.scanner = new Scanner(input);
		giocatori = new Giocatore[2];
		selezionaAvversario();
		avvia();
	}

	/**
	 * Richiede all'utente di selezionare l'avversario:<br>
	 *  1) Gioca contro il computer<br>
	 *  2) Gioca contro un'altro avversario umano
	 */
	private void selezionaAvversario() {
		System.out.println("- Morra Cinese -\n\nSeleziona il tuo avversario:\n  1) CPU\n  2) Umano\n");
		switch(attendiInputValido("1","2")){
		case "1":
			IA = true;
			break;
		case "2":
			IA = false;
			break;
		}
	}
	
	/**
	 * Lancia un ciclo di gioco (basato sul parametro fissato ROUNDS)<br>
	 * Inizializza i due giocatori e avvia i round
	 */
	private void avvia() {
		giocatori[0] = new Giocatore();
		giocatori[1] = new Giocatore();
		int cont = 0;
		while (cont < ROUNDS){
			System.out.println("Round " + (cont+1) + ":");
			round();
			cont++;
		}
		valutaPartita();
		chiudi();
	}
	
	/**
	 * Gestisce un singolo round.<br>
	 * In particolare chiede all'utente di scegliere la sua mossa e,<br>
	 * nel caso l'avversario sia un IA, genera una scelta casuale<br>
	 * altrimenti chiede un secondo input al giocatore 2.<br>
	 * Infine richiede l'esito della sfida e assegna un punto al vincitore.
	 */
	private void round() {
		ArrayList<Scelta> scelte = new ArrayList<Scelta>();
		int id = 1;
		do{
			System.out.println("Giocatore " + id +", qual è la tua scelta?");
			String input = attendiInputValido("sasso","carta","forbice");
			scelte.add(Scelta.parseInput(input));
			System.out.println("Il giocatore " + id + " ha scelto " + scelte.get(id-1) + "!");
			if(IA){
				Scelta sceltaCPU = Scelta.getSceltaCasuale(new Random());
				scelte.add(sceltaCPU);
				System.out.println("La CPU ha scelto " + sceltaCPU + "!");
				id = 3;
			}else
				id++;
		}while(id<3);
		Risultato risultato = sceltaFatta(scelte);
		if(risultato.equals(Risultato.WINNER))
			giocatori[0].addPunto();
		else if(risultato.equals(Risultato.LOSER))
			giocatori[1].addPunto();
		if(IA || risultato.equals(Risultato.DRAW))
			System.out.println(risultato + "\n");
		else
			System.out.println("Giocatore " + (risultato.ordinal()+1) + " vince!\n");
	}
	
	/**
	 * Confronta le due mosse; la convenzione utilizzata è "X sfida Y".
	 * @param scelte è un'array costituito dalle due mosse del round corrente.
	 * @return l'esito per X
	 */
	private Risultato sceltaFatta(ArrayList<Scelta> scelte) {
		return scelte.get(0).risultatoContro(scelte.get(1));
	}
	
	/**
	 * Controlla chi fra i 2 giocatori ha segnato più punti e stampa il vincitore o notifica la condizione di pareggio.
	 * Infine richiede all'utente se avviare una nuova partita o meno ed esegue.
	 */
	private void valutaPartita(){
		int punteggio1 = giocatori[0].getPunteggio();
		int punteggio2 = giocatori[1].getPunteggio();
		if(punteggio1 == punteggio2)
			System.out.println("La partita termina in parità!");
		else if(punteggio1 > punteggio2)
			System.out.println("Vince la partita il giocatore 1!");
		else if(IA)
			System.out.println("Vince la partita la CPU!");
		else
			System.out.println("Vince la partita il giocatore 2!");
		System.out.println("Vuoi avviare una nuova partita? (Si/No)");
		if(attendiInputValido("si","no").equals("si"))
			avvia();
	}
	
	/**
	 * Chiude la console (il thread viene arrestato automaticamente)
	 */
	private void chiudi() {
		scanner.close();
	}
	
	/**
	 * Controlla che l'utente inserisca un input valido
	 * @param valide è l'array di stringhe accettate
	 * @return l'input dell'utente una volta che questo è corretto
	 */
	private String attendiInputValido(String... valide){
		while(true){
			String input = scanner.next();
			for(String s: valide)
				if(input.toLowerCase().equals(s))
					return input;
			System.out.println("Risposta non valida, riprova.");
		}
	}

	
	public static void main(String[] args) {
		Gioco gioco = new Gioco(System.in);
	}
}
