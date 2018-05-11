package com.pablomonteserin.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pablomonteserin.BO.LibroBO;
import com.pablomonteserin.entity.Libro;

public class LibroAction extends ActionSupport{
	private Libro libro;
	private List<Libro> libros;
	
	
	public String alta() {
		LibroBO libroBO = new LibroBO();
		libroBO.alta(libro);
		return SUCCESS;
	}
	
	public String inicioModificacionLibro() {
		LibroBO libroBO = new LibroBO();
		libro = libroBO.getLibro(libro);
		return SUCCESS;
		
	}
	
	public String modificaomuere() {
		LibroBO libroBO = new LibroBO();
		libroBO.actualizaOMuere(libro);
		return SUCCESS;
	}
	
	public String borraRecorcholis() {
		LibroBO libroBO = new LibroBO();
		libroBO.borra(libro);
		return SUCCESS;
	}
	public String consulta() {
		LibroBO libroBO = new LibroBO();
		libros = libroBO.list();
		return SUCCESS;
	}
	public Libro getLibro() {
		return libro;
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
