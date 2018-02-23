package com.pablomonteserin;

public class Servicios {
	float getPrecioConIva(float precioSinIVA) throws PrecioDemasiadoAltoException {
		float precioConIva = precioSinIVA * 1.16f;
		
		if(precioConIva>100)throw new PrecioDemasiadoAltoException();
		return precioConIva;
	}
}
