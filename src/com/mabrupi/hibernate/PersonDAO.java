package com.mabrupi.hibernate;

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
	
	
	
}
















