package com.pablomonteserin.excepcion;

import java.io.PrintStream;

public class PrecioDemasiadoAltoException extends Exception {

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
		System.out.println("Eso es muy caro!");
	}
	
	@Override
	public void printStackTrace(PrintStream s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}
}
