package com.pablomonteserin.BO;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.pablomonteserin.HibernateUtil;
import com.pablomonteserin.entity.Paciente;

public class PacienteBO {

	public void alta(String nombre, String apellidos, Date fecha) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Paciente paciente = new Paciente();
		paciente.setNombre(nombre);
		paciente.setApellidos(apellidos);
		paciente.setFecha(fecha);
		
		session.save(paciente);
		transaction.commit();
		session.close();
	}
	
	public List<Paciente> list() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query<Paciente> hqlQuery = session.createQuery("FROM Paciente");
		List<Paciente> result = hqlQuery.list();
		
		session.close();
		return result;
	}
	
	
	public Paciente getPaciente(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query<Paciente> hqlQuery = session.createQuery("FROM Paciente WHERE id=(:condicion)");
		hqlQuery.setParameter("condicion", id);
		Paciente paciente = hqlQuery.uniqueResult();
		
		session.close();
		return paciente;
	}
	
	public void salvar(Paciente paciente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();	
		session.update(paciente);
		transaction.commit();
		session.close();
	}
	
	public void borrar(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();	
		Paciente paciente = new Paciente();
		paciente.setId(id);
		session.remove(paciente);
		transaction.commit();
		session.close();
	}
}
