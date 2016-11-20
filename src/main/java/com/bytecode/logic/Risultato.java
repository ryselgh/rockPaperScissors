package com.bytecode.logic;

/**
 * Questo enum rappresenta i 3 possibili esiti di un singolo round
 */
public enum Risultato {
	
	WINNER("Hai vinto!"), LOSER("Hai perso!"), DRAW("Parità!");
	
	private final String messaggio;
	
	private Risultato(String messaggio){
		this.messaggio = messaggio;
	}
	
	/**
	 * Trasforma il risultato in una stringa predefinita,<br>
	 * facilitando la stampa alla CLI
	 */
	@Override
	public String toString() {
		return messaggio;
	}
	
	/**
	 * Controlla la condizione in ingresso e restituisce il Risultato;
	 * @param condizione determina il risultato<br>
	 *  TRUE: Vittoria<br>
	 *  FALSE: Sconfitta<br>
	 * @return il Risultato
	 */
	public static Risultato vinceSe(boolean condizione){
		return (condizione)?Risultato.WINNER:Risultato.LOSER;
	}
	
	
}
