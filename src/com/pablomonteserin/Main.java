package com.pablomonteserin;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Introduce el precio: ");
		Scanner scanner = new Scanner(System.in);
		float precio = scanner.nextFloat();
		
		Servicios servicios = new Servicios();
		
		try {
			float valorDevuelto  = servicios.getPrecioConIva(precio);
		} catch (PrecioDemasiadoAltoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
