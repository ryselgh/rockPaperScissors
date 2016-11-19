package com.bytecode.logic;

import java.util.Random;

public enum Scelta {
	
	CARTA, FORBICE, SASSO;
	public Risultato risultatoContro(Scelta altro) {
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

	public static Scelta parseInput(String input) {
		return Enum.valueOf(Scelta.class, input.toUpperCase());
	}

	public static Scelta getSceltaCasuale(Random random) {
		Scelta[] valori = Scelta.values();
		return valori[random.nextInt(valori.length)];
	}

	@Override
	public String toString() {
		return super.toString().toLowerCase();
	}
	
}
