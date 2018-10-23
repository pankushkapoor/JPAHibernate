package com.cg.project.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.project.beans.Associate;
import com.cg.project.beans.BankDetails;
import com.cg.project.beans.Salary;
import com.cg.project.daoservices.AssociateDAO;
import com.cg.project.daoservices.AssociateDAOImpl;

public class MainClass {

	public static void main(String[] args) {
		/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");//encapsulate all info of ur hibernate, entity manager. heavy object
		EntityManager entityManager = factory.createEntityManager(); //to provide persistence services for your single object */		

		AssociateDAO dao = new AssociateDAOImpl();
		Associate associate1 = new Associate(1000, "PK", "KP", "pk@gmail.com", "SA", "ADM", "pk1274381", new BankDetails(101, "HDFC", "HDFC001101"), new Salary(4500, 1000, 1000));
		//System.out.println(associate1);
		associate1 = dao.save(associate1);
		System.out.println(associate1.getAssociateId());
		Associate associate2 = new Associate(2000, "PKP", "KPK", "pppkk@gmail.com", "ASA", "ADMA", "AAApk1274381", new BankDetails(102, "HDFC", "HDFC002222"), new Salary(44500, 11000, 10200));
		associate2 = dao.save(associate2);
		System.out.println(dao.findAll());
		int associateId = associate2.getAssociateId();
		dao.update(new Associate(2, "PKafwP", "KfwawafPK", "pppkk@gmaafwil.com", "AfwaSA", "ADwafMA", "AAApk1waf274381", new BankDetails(102, "HDFC", "HDFC002222"), new Salary(44500, 11000, 10200)));
		System.out.println(dao.findAll());



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
