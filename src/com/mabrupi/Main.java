package com.mabrupi;

import org.hibernate.Session;

public class Main {

	public static void main(String[] args) {

		Person user1=new Person();  
		user1.setName("Arpit");  
		user1.setSurname("Surname for arpit");  
		
		Person user2=new Person();  
		user2.setName("Ankita");  
		user2.setSurname("Surname for ankita"); 
		
		Session ss=HibernateUtil.getSessionFactory().openSession();  
		ss.beginTransaction();  
		ss.save(user1);  
		ss.save(user2);  
		ss.getTransaction().commit();  
		ss.close();  

	}  
}

