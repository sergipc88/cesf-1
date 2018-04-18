package com.pablomonteserin;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class InvitadoBO {
public List<Invitado> list(){
	Session session = HibernateUtil.getSessionFactory().openSession();
	Query hqlQuery = session.createQuery("FROM  Invitado");
	List <Invitado> invitados = hqlQuery.list();
	
	session.close();
	
	return invitados;
}


public void alta(String nombre) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	Invitado invitado = new Invitado();
	invitado.setNombre(nombre);
	session.save(invitado);
	
	transaction.commit();
	session.close();

}

public void baja(int id) {
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = session.beginTransaction();
	Invitado invitado = new Invitado();
	Invitado personaABorrar = (Invitado) session.load(Invitado.class, id);
	session.delete(personaABorrar);	
	transaction.commit();
	session.close();

}
}
