package com.pablomonteserin.bo;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.pablomonteserin.HibernateUtil;
import com.pablomonteserin.entities.Libro;

public class LibroBO {
	public Libro getLibroByIsbn(String isbn) throws NoResultException {
		Session session = HibernateUtil.getSessionFactory().openSession();
	
		
		Query<Libro> hqlQuery = session.createQuery("FROM  Libro WHERE isbn=(:condicion)");
		hqlQuery.setParameter("condicion", isbn);
		
		Libro libro = hqlQuery.getSingleResult();
		
		
		session.close();
		
return libro;		
	}
}
