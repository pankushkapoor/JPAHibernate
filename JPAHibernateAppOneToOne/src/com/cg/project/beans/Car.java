package com.cg.project.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int carCode;
	private String modelName;
	private int price;
	@OneToOne
	private Customer customer;
	
	public Car() {
		super();
	}

	public Car(int carCode, String modelName, int price) {
		super();
		this.carCode = carCode;
		this.modelName = modelName;
		this.price = price;
	}

	public int getCarCode() {
		return carCode;
	}

	public void setCarCode(int carCode) {
		this.carCode = carCode;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Car [carCode=" + carCode + ", modelName=" + modelName
				+ ", price=" + price + "]";
	}
	
}
