package com.pablomonteserin;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


public class LibroBO {
 
	public List<Libro> getLibros(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		LibroDAO libroDAO = new LibroDAO();
		List<Libro> libros = libroDAO.getLibros();
		session.close();	
		return libros;
	}
	
	public List<Libro> alta(String titulo, int precio) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		LibroDAO libroDAO = new LibroDAO();
		libroDAO.alta(titulo, precio);
		
		List<Libro> libros = libroDAO.getLibros();

		session.close();
		return libros;
	}
	
	public List<Libro> borrar( int identificador) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		LibroDAO libroDAO = new LibroDAO();
		libroDAO.borrar(identificador);
		
		List<Libro> libros = libroDAO.getLibros();

		session.close();
		return libros;
	}
	
	public List<Libro> modificar(String titulo, int precio, int identificador) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		LibroDAO libroDAO = new LibroDAO();
		libroDAO.modificar(titulo, precio,identificador);
		
		List<Libro> libros = libroDAO.getLibros();

		session.close();
		return libros;
	}
}
