package com.mabrupi;

import java.util.List;

import org.hibernate.Session;

import com.mabrupi.hibernate.AddressDAO;
import com.mabrupi.hibernate.PersonDAO;
import com.mabrupi.hibernate.utils.HibernateUtil;

public class Main {

	public static void main(String[] args) {

		Person user1=new Person();  
		user1.setName("Arpit");  
		user1.setSurname("Surname for arpit");
		user1.setAge(25);
		user1.setActivo(true);
		
		Person user2=new Person();  
		user2.setName("Ankita");  
		user2.setSurname("Surname for ankita"); 
		user2.setAge(63);
		user2.setActivo(false);
		
		Address address1 = new Address();
		address1.setCity("Valencia");
		address1.setKindOfStreet("Avenida");
		address1.setNameStreet("Del Puerto");
		
		new AddressDAO().saveAddress(address1);
		System.out.println(address1.getIdAddress());
		
		user1.setHomeAddress(address1);
		user2.setHomeAddress(address1);
		
		new PersonDAO().savePerson(user1);
		new PersonDAO().savePerson(user2);
		
				
		List <Person> p1 = new PersonDAO().getListPerson();
		System.out.println(p1.size());
		
		System.exit(1);
	}  
}

