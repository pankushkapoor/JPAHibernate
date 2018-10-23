package com.cg.project.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int customerNo;
	private String firstName, lastName, email;
	@OneToMany(mappedBy="customer")
	private List<Car> cars;
	public Customer() {
		super();
	}
	public Customer(int customerNo, String firstName, String lastName,
			String email, List<Car> cars) {
		super();
		this.customerNo = customerNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.cars = cars;
	}
	public int getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Car> getCar() {
		return cars;
	}
	public void setCar(List<Car> cars) {
		this.cars = cars;
	}
	@Override
	public String toString() {
		return "Customer [customerNo=" + customerNo + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}
	
	
}
