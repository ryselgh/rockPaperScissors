package com.bytecode.logic;

public class Giocatore {
	
	private int punteggio;
	
	/**
	 * Inizializza il punteggio
	 */
	public Giocatore(){
		punteggio = 0;
	}
	
	/**
	 * Aggiunge un punto al giocatore
	 */
	public void addPunto(){
		punteggio++;
	}
	
	/**
	 * @return il punteggio del giocatore
	 */
	public int getPunteggio(){
		return punteggio;
	}
	
}
