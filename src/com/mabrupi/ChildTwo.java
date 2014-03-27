package com.mabrupi;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("childTwo")
public class ChildTwo extends Father {
	private String childTwo;
	
	public ChildTwo(){}

	public String getChildTwo() {
		return childTwo;
	}

	public void setChildTwo(String childTwo) {
		this.childTwo = childTwo;
	}


	
}
