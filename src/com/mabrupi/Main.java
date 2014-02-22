package com.mabrupi;

import org.hibernate.Session;

import com.mabrupi.hibernate.PersonDAO;
import com.mabrupi.hibernate.utils.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		Person user1=new Person();  
		user1.setName("Arpit");  
		user1.setSurname("Surname for arpit");  
		
		Person user2=new Person();  
		user2.setName("Ankita");  
		user2.setSurname("Surname for ankita"); 
		
		new PersonDAO().savePerson(user1);
		new PersonDAO().savePerson(user2);
		
		user1.setName("Nombre editado");
		new PersonDAO().updatePerson(user1);
		
		System.out.println(user1.getName());
		System.out.println(user2.getIdPerson());

	}  
}

