package com.pablomonteserin.hibernateprueba;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Alumno alumno = new Alumno();
		alumno.setNombre("Juan");
		alumno.setEdad(34);
		
		
		session.save(alumno);
		transaction.commit();
		session.close();
		HibernateUtil.shutdown();
		
		
		
	}

}
