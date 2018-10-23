package com.cg.project.services;

import java.util.ArrayList;

import com.cg.project.beans.Associate;
/*import com.cg.payroll.beans.BankDetails;
import com.cg.payroll.beans.Salary;*/
import com.cg.project.exceptions.AssociateDetailsNotFoundException;


public interface PayrollServices {
	int acceptAssociateDetails(int yearlyInvestmentUnder80C,
			String firstName, String lastName, String department,
			String designation, String pancard, String emailId,int basicSalary,int epf,int companyPf,
			int accountNumber, String bankName, String ifscCode);
	
	int calculateNetSalary(int associateId) throws AssociateDetailsNotFoundException;
	
	Associate getAssociateDetails(int associateId) throws AssociateDetailsNotFoundException;

	ArrayList<Associate> getAllAssociateDetails();
	//ArrayList<Associate> getAllAssociateDetails() throws PayrollServicesDownException;

}
