package com.bytecode.logic;

import java.util.Random;

/**
 * Questo enum rappresenta le 3 possibili scelte<br>
 * (note a priori) dei giocatori durante un round.
 */
public enum Scelta {
	
	CARTA, FORBICE, SASSO;
	
	/**
	 * Controlla se la Scelta che invoca il metodo vince su quella nell'argomento
	 * @param altro Scelta dell'avversario
	 * @return Risultato del confronto rispetto all'invocante
	 * @throws NullPointerException se l'argomento è nullo
	 */
	public Risultato risultatoContro(Scelta altro) {
		if(altro==null)
			throw new NullPointerException("L'argomento non può essere nullo.");
		if (this == altro) {
			return Risultato.DRAW;
		}
		switch (this) {
		case CARTA:
			return Risultato.vinceSe(altro == Scelta.SASSO);
		case FORBICE:
			return Risultato.vinceSe(altro == Scelta.CARTA);
		case SASSO:
			return Risultato.vinceSe(altro == Scelta.FORBICE);
		default:
			return null;
		}
	}
	
	/**
	 * Trasforma la stringa in ingresso in una Scelta
	 * @param input la stringa rappresentante la scelta
	 * @return la Scelta corrispondente
	 * @throws NullPointerException se la stringa è nulla
	 */
	public static Scelta parseInput(String input) {
		if(input==null)
			throw new NullPointerException("L'argomento non può essere nullo.");
		return Enum.valueOf(Scelta.class, input.toUpperCase());
	}
	
	/**
	 * Restituisce una Scelta casuale
	 * @param random un parametro non nullo di tipo Random
	 * @return una Scelta casuale
	 * @throws NullPointerException se l'argomento è nullo
	 */
	public static Scelta getSceltaCasuale(Random random) {
		if(random==null)
			throw new NullPointerException("L'argomento non può essere nullo.");
		Scelta[] valori = Scelta.values();
		return valori[random.nextInt(valori.length)];
	}
	
	/**
	 * E' un normale toString() che restituisce il valore in minuscolo per facilitare la stampa alla CLI
	 * @return la stringa in miuscolo
	 */
	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
	
}
