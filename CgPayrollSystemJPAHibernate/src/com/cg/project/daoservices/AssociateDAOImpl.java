package com.cg.project.daoservices;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.cg.project.beans.Associate;
import com.cg.project.util.EntityManagerFactoryProvider;

public class AssociateDAOImpl implements AssociateDAO{
	EntityManagerFactory factory = EntityManagerFactoryProvider.getEntityManagerFactory();
	@Override
	public Associate save(Associate associate) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(associate);
		entityManager.getTransaction().commit();
		entityManager.close();
		return associate;
	}

	@Override
	public Associate findOne(int associateId) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		return entityManager.find(Associate.class, associateId);
	}

	@Override
	public ArrayList<Associate> findAll() {
		EntityManager entityManager = factory.createEntityManager();
		//Query query = entityManager.createQuery("FROM Associate a"); //Associate is the entity name and not the class name or table name. but there is mapping
		Query query = entityManager.createNamedQuery("getAllAssociate");
		@SuppressWarnings("unchecked")
		ArrayList<Associate> list = (ArrayList<Associate>)query.getResultList();
		return list;
	}

	@Override
	public boolean update(Associate associate) {
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(associate);
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Override
	public ArrayList<Associate> findFewAssociate(int yearlyInvestmentUnder80C) {
		EntityManager entityManager = factory.createEntityManager();
		Query query = entityManager.createNamedQuery("getFewAssociate");
		query.setParameter("yearlyInvestmentUnder80C", yearlyInvestmentUnder80C);
		@SuppressWarnings("unchecked")
		ArrayList<Associate> list = (ArrayList<Associate>)query.getResultList();
		return list;
	}

}
