package com.mabrupi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity(name="person")
public class Person {
	
	@Id @GeneratedValue
	private int idPerson;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	private int age;
	private boolean activo;
	
	@OneToOne
	@JoinColumn(name="idAddress")
	private Address homeAddress;
	
	public Person(){}

	public int getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	};
	
	

}
