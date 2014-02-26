package com.mabrupi.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mabrupi.Address;
import com.mabrupi.hibernate.utils.HibernateUtil;

public class AddressDAO {
	private Session session;
	private Transaction tx;
	
	private void iniciaOperacion(){
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he) {
		tx.rollback();
		System.out.println("Ocurrió un error en hibernate manejando direcciones");
	}
	
	public boolean saveAddress(Address p){
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
	
	public boolean updateAddress(Address p){
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
	
	public boolean deleteAddress(Address p){
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
	
	public Address getAddress(int idAddress) 
	{ 
	    Address person = null;  
	    try 
	    { 
	        iniciaOperacion(); 
	        person = (Address) session.get(Address.class, idAddress); 
	    } finally 
	    { 
	        session.close(); 
	    }  
	    return person; 
	}
	
	public List<Address> getListAddress(){
		List<Address> listAdress = null;
		try{
			iniciaOperacion();
			listAdress = session.createQuery("from adress").list();
		} finally {
			session.close();
		}
		return listAdress;
	}
	
	
	
}
















