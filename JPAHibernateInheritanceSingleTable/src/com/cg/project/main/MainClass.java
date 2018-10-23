package com.cg.project.main;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JPA-PU");

	}
}
