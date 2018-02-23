package com.pablomonteserin;

public class PrecioDemasiadoAltoException extends Exception {

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
		System.out.println("Eso es muy caro!");
	}
}
