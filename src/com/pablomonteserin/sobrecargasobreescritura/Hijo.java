package com.pablomonteserin.sobrecargasobreescritura;

public class Hijo extends Padre {

	@Override
	public int cantar(String cancioncilla) {
		int resultado = cancioncilla.length()*5-3;
		return resultado;
	}
	
	public void bailar(String cancion) {
	}
}
