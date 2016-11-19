package com.bytecode.logic;

public enum Risultato {
	
	WINNER("Hai vinto!"), LOSER("Hai perso!"), DRAW("Parità!");
	
	private final String messaggio;
	
	private Risultato(String messaggio){
		this.messaggio = messaggio;
	}
	
	@Override
	public String toString() {
		return messaggio;
	}
	
	public static Risultato vinceSe(boolean condizione){
		return (condizione)?Risultato.WINNER:Risultato.LOSER;
	}
	
	
}
