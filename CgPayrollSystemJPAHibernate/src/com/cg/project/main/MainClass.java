package com.cg.project.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.project.beans.Associate;
import com.cg.project.beans.BankDetails;
import com.cg.project.beans.Salary;
import com.cg.project.daoservices.AssociateDAO;
import com.cg.project.daoservices.AssociateDAOImpl;
import com.cg.project.exceptions.AssociateDetailsNotFoundException;
import com.cg.project.services.PayrollServices;
import com.cg.project.services.PayrollServicesImpl;

public class MainClass {

	public static void main(String[] args) throws AssociateDetailsNotFoundException {
		/*PayrollServices services = new PayrollServicesImpl();
		
		services.acceptAssociateDetails(1100, "Pank", "Kap", "ADM", "SA", "PK123243", "pk@gmail.com", 10000, 2000, 3000, 101, "HDFC", "HDFC101010");
		System.out.println(services.getAssociateDetails(1));
		services.calculateNetSalary(1);
		System.out.println(services.getAssociateDetails(1));
		System.out.println();*/
		
		AssociateDAO dao = new AssociateDAOImpl();
		Associate associate1 = new Associate(1000, "PK", "KP", "pk@gmail.com", "SA", "ADM", "pk1274381", new BankDetails(101, "HDFC", "HDFC001101"), new Salary(4500, 1000, 1000));
		associate1 = dao.save(associate1);
//		/System.out.println(associate1);
		System.out.println(dao.findFewAssociate(20000));
		
		/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");//encapsulate all info of ur hibernate, entity manager. heavy object
		EntityManager entityManager = factory.createEntityManager(); //to provide persistence services for your single object */		

		/*AssociateDAO dao = new AssociateDAOImpl();
		Associate associate1 = new Associate(1000, "PK", "KP", "pk@gmail.com", "SA", "ADM", "pk1274381", new BankDetails(101, "HDFC", "HDFC001101"), new Salary(4500, 1000, 1000));
		//System.out.println(associate1);
		associate1 = dao.save(associate1);
		System.out.println(associate1.getAssociateId());
		Associate associate2 = new Associate(2000, "PKP", "KPK", "pppkk@gmail.com", "ASA", "ADMA", "AAApk1274381", new BankDetails(102, "HDFC", "HDFC002222"), new Salary(44500, 11000, 10200));
		associate2 = dao.save(associate2);
		System.out.println(dao.findAll());*/




		/*Associate associate1 = new Associate("Pankush", "Kapoor", "pankush@gmail.com", "SA");
		associate1 = dao.save(associate1);

		int associateId = associate1.getAssociateId();
		System.out.println("Associate ID = " + associateId);
		System.out.println(dao.findOne(1));
		Associate associate2 = new Associate("Pank", "Kap", "pank@gmail.com", "SA");
		associate2 = dao.save(associate2);
		Associate associate3 = new Associate("Panku", "Kapoo", "panku@gmail.com", "SA");
		associate3 = dao.save(associate3);
		System.out.println(dao.findAll());
		dao.update(new Associate(2,"fghygfhu", "Kapoo", "panku@gmghhgfail.com", "SA"));
		System.out.println(dao.findAll());*/
	}

}
