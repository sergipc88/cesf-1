package com.pablomonteserin;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class LibroDAO {
	public List<Libro> getLibros(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query hqlQuery = session.createQuery("FROM  Libro");
		List<Libro> libros = hqlQuery.list();		
		return libros;
	}
	
	public void alta(String titulo, int precio) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Libro libro = new Libro();
		libro.setTitulo(titulo);
		libro.setPrecio(precio);
		session.save(libro);

		transaction.commit();

	} 
	

	public void borrar(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		String queryString = "delete from Libro where id=(:condicion)";
		Query hqlQuery = session.createQuery(queryString);
		hqlQuery.setParameter("condicion", id);
		hqlQuery.executeUpdate();

		transaction.commit();

	} 
	
	
	public void modificar(String titulo, int precio, int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		Libro libro = new Libro();
		libro.setTitulo(titulo);
		libro.setPrecio(precio);
		libro.setId(id);
		session.update(libro);

		transaction.commit();

	} 
}
