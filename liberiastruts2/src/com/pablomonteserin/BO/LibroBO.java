package com.pablomonteserin.BO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pablomonteserin.actions.LibroAction;
import com.pablomonteserin.entity.Libro;
import com.pablomonteserin.utils.HibernateUtil;

public class LibroBO {
	public void alta(Libro libro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(libro);
		
		transaction.commit();
		session.close();
	}
	public void borra(Libro libro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.remove(libro);
		
		transaction.commit();
		session.close();
	}
	
	public void actualizaOMuere(Libro libro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(libro);
		
		transaction.commit();
		session.close();

	}
	
	public List<Libro> list(){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query hqlQuery = session.createQuery("FROM  Libro");
		List<Libro> libros = hqlQuery.list();
		
		session.close();
		return libros;
	}
	
	public Libro getLibro(Libro libro) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		String queryString = "FROM Libro where id=(:condicion)";
		Query<Libro> hqlQuery = session.createQuery(queryString);
		hqlQuery.setParameter("condicion", libro.getId());
		libro = hqlQuery.uniqueResult();
		session.close();
		return libro;

		
	}
}
