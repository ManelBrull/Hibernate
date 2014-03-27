package com.mabrupi;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mabrupi.hibernate.AddressDAO;
import com.mabrupi.hibernate.PersonDAO;
import com.mabrupi.hibernate.utils.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		Father father = new ChildOne();
		father.setName("Chanquete");
		Session session;
		Transaction tx;
		
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
		
		session.save((Father)father);
		tx.commit();
	}  
}

