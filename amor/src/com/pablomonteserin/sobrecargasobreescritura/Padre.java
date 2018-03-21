package com.pablomonteserin.sobrecargasobreescritura;

public class Padre {
	protected int cantar(String cancion) {
		return cancion.length();
	}
	
	public int bailar(String cancion, int duracion) {
		
		return 6;
	}
}
