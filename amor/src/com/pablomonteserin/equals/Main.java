package com.pablomonteserin.equals;

public class Main {
public static void main(String args[]) {
	Cubo cubo1 = new Cubo(3,3,3);
	Cubo cubo2 = new Cubo(3,3,3);
	
	if(cubo1.equals(cubo2)) {
		System.out.println("son iguales");
	}else {
		System.out.println("son diferentes");
	}
}
}
