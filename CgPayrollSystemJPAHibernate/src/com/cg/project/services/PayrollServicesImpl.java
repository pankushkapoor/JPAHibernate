package com.cg.project.services;

import java.util.ArrayList;

import com.cg.project.beans.Associate;
import com.cg.project.beans.BankDetails;
import com.cg.project.beans.Salary;
import com.cg.project.daoservices.AssociateDAO;
import com.cg.project.daoservices.AssociateDAOImpl;
import com.cg.project.exceptions.AssociateDetailsNotFoundException;
import com.cg.project.exceptions.PayrollServicesDownExceptions;

public class PayrollServicesImpl implements PayrollServices{
	private AssociateDAO associateDAO=new AssociateDAOImpl();

	@Override
	public int acceptAssociateDetails(int yearlyInvestmentUnder80C,
			String firstName, String lastName, String department,
			String designation, String pancard, String emailId,
			int basicSalary, int epf, int companyPf, int accountNumber,
			String bankName, String ifscCode)
	{
		Associate associate=new Associate(yearlyInvestmentUnder80C, firstName, lastName, department, designation, pancard, emailId, new BankDetails((int)accountNumber, bankName, ifscCode),new Salary(basicSalary, epf, companyPf));
		associate=associateDAO.save(associate);
		return associate.getAssociateId();
	}

	@Override
	public int calculateNetSalary(int associateId)
			throws AssociateDetailsNotFoundException
	{	Associate associate=null;
		associate = getAssociateDetails(associateId);
		
		associate.setSalary(new Salary(associate.getSalary().getBasicSalary()));
		System.out.println("Basic Salary : "+associate.getSalary().getBasicSalary());
		System.out.println("Personal Allowance : "+associate.getSalary().getPersonalAllowance());
		System.out.println("HRA : "+associate.getSalary().getHra());
		System.out.println("OtherAllowance : "+associate.getSalary().getOtherAllowance());
		System.out.println("Conveyence Allowance : "+associate.getSalary().getConveyenceAllowance());
		System.out.println("Gross Salary : "+associate.getSalary().getGrossSalary());

		associate.getSalary().setNetSalary(associate.getSalary().getGrossSalary());

		int salaryPerAnnum=(associate.getSalary().getGrossSalary()*12);
		if(salaryPerAnnum<=250000){
			associate.getSalary().setMonthlyTax(0);
		}
		else if(salaryPerAnnum>250000 && salaryPerAnnum<=500000)
			associate.getSalary().setMonthlyTax((10*(associate.getSalary().getGrossSalary()-250000))/(100*12));
		else if(salaryPerAnnum>500000 && salaryPerAnnum<=1000000){
			int tillfive=25000;
			int tillten=(20*(1000000-associate.getSalary().getBasicSalary()))/100;
			associate.getSalary().setMonthlyTax((tillfive+tillten)/12);
		}
		associate.getSalary().setNetSalary((associate.getSalary().getBasicSalary())-(associate.getSalary().getMonthlyTax()));
		associateDAO.update(associate);
		return associate.getSalary().getNetSalary();
	}

	@Override
	public Associate getAssociateDetails(int associateId)
			throws AssociateDetailsNotFoundException {
		Associate associate = null;

		associate = associateDAO.findOne(associateId);
		if(associate==null) throw new AssociateDetailsNotFoundException("Associate Details not found");
		return associate;
	}

	@Override
	public ArrayList<Associate> getAllAssociateDetails(){

		return associateDAO.findAll();
	}

}