package com.cg.project.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
																		//entity is any class which has a PKey
@Entity 																//should be added if we are gonna use the persistence of this class. if we've written @Entity(name="associate_master"), table name would be entity name. can also use @Table(name="associate_master_table")
public class Associate { 												//table name would be the entity name
	@Id 																//that class need to have one field with the annotation - ID
	@GeneratedValue(strategy=GenerationType.AUTO) 						//SEQUENCE, TABLE, AUTO, IDENTITY
	private int associateId; 											// it will become the primary key
	private int yearlyInvestmentUnder80C;
	private String firstName, lastName, email, designation, department, pancard;
	@Embedded
	private BankDetails bankdetails;
	@Embedded
	private Salary salary;
	public Associate() {
		super();
	}
	public Associate(int associateId, String firstName, String lastName,
			String email, String designation) {
		super();
		this.associateId = associateId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.designation = designation;
	}
	public Associate(String firstName, String lastName, String email,
			String designation) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.designation = designation;
	}

	public Associate(int yearlyInvestmentUnder80C,
			String firstName, String lastName, String email,
			String designation, String department, String pancard, BankDetails bankdetails, Salary salary) {
		super();
		this.yearlyInvestmentUnder80C = yearlyInvestmentUnder80C;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.designation = designation;
		this.department = department;
		this.pancard = pancard;
		this.bankdetails = bankdetails;
		this.salary = salary;
	}
	

	public Associate(int associateId, int yearlyInvestmentUnder80C,
			String firstName, String lastName, String email,
			String designation, String department, String pancard,
			BankDetails bankdetails, Salary salary) {
		super();
		this.associateId = associateId;
		this.yearlyInvestmentUnder80C = yearlyInvestmentUnder80C;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.designation = designation;
		this.department = department;
		this.pancard = pancard;
		this.bankdetails = bankdetails;
		this.salary = salary;
	}
	public int getAssociateId() {
		return associateId;
	}
	public void setAssociateId(int associateId) {
		this.associateId = associateId;
	}
	public int getYearlyInvestmentUnder80C() {
		return yearlyInvestmentUnder80C;
	}
	public void setYearlyInvestmentUnder80C(int yearlyInvestmentUnder80C) {
		this.yearlyInvestmentUnder80C = yearlyInvestmentUnder80C;
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
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPancard() {
		return pancard;
	}
	public void setPancard(String pancard) {
		this.pancard = pancard;
	}
	public BankDetails getBankdetails() {
		return bankdetails;
	}
	public void setBankdetails(BankDetails bankdetails) {
		this.bankdetails = bankdetails;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Associate [associateId=" + associateId
				+ ", yearlyInvestmentUnder80C=" + yearlyInvestmentUnder80C
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", designation=" + designation
				+ ", department=" + department + ", pancard=" + pancard
				+ ", bankdetails=" + bankdetails
				+ ", salary=" + salary + "]";
	}

}
