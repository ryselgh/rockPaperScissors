package com.bytecode.logic;

public class Giocatore {
	
	private int punteggio;
	
	
	public Giocatore(){
		punteggio = 0;
	}
	
	
	public void addPunto(){
		punteggio++;
	}
	
	public int getPunteggio(){
		return punteggio;
	}
	
}
