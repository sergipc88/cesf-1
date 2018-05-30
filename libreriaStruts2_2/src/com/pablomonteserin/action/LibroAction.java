package com.pablomonteserin.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pablomonteserin.BO.LibroBO;
import com.pablomonteserin.entity.Libro;

public class LibroAction extends ActionSupport {
private Libro libro;
private List<Libro> libros;


public String insertar() {
	LibroBO libroBO = new LibroBO();
	libroBO.insertar(libro);
	return SUCCESS;
}
public Libro getLibro() {
	return libro;
}
public String consultaLibros() {
	LibroBO libroBO = new LibroBO();
libros = libroBO.consultaLibros();
	return SUCCESS;
}
public String eliminaLibro() {
	LibroBO libroBO = new LibroBO();
	libroBO.eliminar(libro);
	return SUCCESS;
	
}

public String modificaLibro() {
	LibroBO libroBO = new LibroBO();
	libroBO.modifica(libro);
	return SUCCESS;
	
}
public void setLibro(Libro libro) {
	this.libro = libro;
}
public List<Libro> getLibros() {
	return libros;
}
public void setLibros(List<Libro> libros) {
	this.libros = libros;
}


}
