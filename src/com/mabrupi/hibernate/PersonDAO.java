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
	
	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Ocurrió un error en hibernate", he);
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
	
	public Person getPerson(long idPerson) 
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
	
	
	
}
















