package com.mabrupi.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mabrupi.Person;
import com.mabrupi.hibernate.utils.HibernateUtil;

public class PersonDAO {
	private Session session;
	private Transaction tx;
	
	private void iniciaOperacion(){
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) {
		tx.rollback();
		System.out.println("Ocurrió un error en hibernate manejando Personas");
	}
	
	public boolean savePerson(Person p){
		boolean state = false;
		try {
			iniciaOperacion();
			session.save(p);
			tx.commit();
			state = true;
		} catch(HibernateException he){
			manejaExcepcion(he);
			state = false;
		} finally {
			session.close();
		}
		return state;
	}
	
	public boolean updatePerson(Person p){
		boolean state = false;
		try{
			iniciaOperacion();
			session.update(p);
			tx.commit();
			state = true;
		} catch(HibernateException he){
			manejaExcepcion(he);
			state = false;
		} finally {
			session.close();
		}
		return state;
	}
	
	public boolean deletePerson(Person p){
		boolean state = false;
		try{
			iniciaOperacion();
			session.delete(p);
			tx.commit();
			state = true;
		} catch(HibernateException he){
			manejaExcepcion(he);
			state = false;
		} finally {
			session.close();
		}
		return state;	
	}
	
	public Person getPerson(int idPerson) 
	{ 
	    Person person = null;  
	    try 
	    { 
	        iniciaOperacion(); 
	        person = (Person) session.get(Person.class, idPerson); 
	    } finally 
	    { 
	        session.close(); 
	    }  
	    return person; 
	}
	
	public List<Person> getListPerson(){
		List<Person> listPerson = null;
		try{
			iniciaOperacion();
			listPerson = session.createQuery("from person").list();
		} finally {
			session.close();
		}
		return listPerson;
	}
	
	public List<Person> getFiltroPerson(String filtro1){
		List<Person> listPerson = null;
		try{
			iniciaOperacion();
			listPerson = session.createQuery("from person").list();
		} finally {
			session.close();
		}
		return listPerson;
	}
	}
	
	
	
}
















