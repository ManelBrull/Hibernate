package com.mabrupi;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("childOne")
public class ChildOne extends Father {
	private String childOne;
	
	public ChildOne(){}

	public String getChildOne() {
		return childOne;
	}

	public void setChildOne(String childOne) {
		this.childOne = childOne;
	}
	
}
