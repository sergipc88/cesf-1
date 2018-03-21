package com.pablomonteserin.equals;

public class Cubo {
	private int ancho, alto, largo;

	
	
	public Cubo(int ancho, int alto, int largo) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.largo = largo;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	
	// cubo1.equals(cubo2)
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cubo)) return false;
		Cubo cubo = (Cubo) obj;
		
		int v1 = largo*ancho*alto;
		int v2 = cubo.largo*cubo.ancho*cubo.alto;
		return v1 == v2;
	}
}
