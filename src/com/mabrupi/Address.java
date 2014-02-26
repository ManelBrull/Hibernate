package com.mabrupi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "address")
public class Address {
	@Id @GeneratedValue
	@Column(name ="idAddress")
	private int idAddress;
	
	private String kindOfStreet;
	private String nameStreet;
	@Column(nullable = false)
	private String city;
	
	public Address(){}

	public int getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(int idAddress) {
		this.idAddress = idAddress;
	}

	public String getKindOfStreet() {
		return kindOfStreet;
	}

	public void setKindOfStreet(String kindOfStreet) {
		this.kindOfStreet = kindOfStreet;
	}

	public String getNameStreet() {
		return nameStreet;
	}

	public void setNameStreet(String nameStreet) {
		this.nameStreet = nameStreet;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}
