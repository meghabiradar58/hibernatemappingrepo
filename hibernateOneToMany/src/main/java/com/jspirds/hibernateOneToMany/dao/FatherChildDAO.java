package com.jspirds.hibernateOneToMany.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;

import com.jspirds.hibernateOneToMany.dto.ChildDTO;
import com.jspirds.hibernateOneToMany.dto.FatherDTO;

public class FatherChildDAO {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	
	private static void openConnections() {
		factory=Persistence.createEntityManagerFactory("OneToMany");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnections() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			try {
				transaction.rollback();
			} catch (TransactionException e) {
				System.out.println
				("Transaction is committed.");
			}
		}
	}
public static void main(String[] args) {
	try {
		openConnections();
		transaction.begin();
		
		FatherDTO father1=new FatherDTO();
		father1.setId(1);
		father1.setName("prabhakar");
		father1.setAge(55);
		//father1.setChildren(children); 
		
		ChildDTO child1=new ChildDTO();
		child1.setId(1);
		child1.setName("Mahesh");
		child1.setAge(27);
		manager.persist(child1);
		
		ChildDTO child2=new ChildDTO();
		child2.setId(2);
		child2.setName("Megha");
		child2.setAge(24);
		manager.persist(child2);
		
		List<ChildDTO> Children=Arrays.asList(child1,child2);
		father1.setChildren(Children);
		manager.persist(father1);
		transaction.commit();
		
	} finally {
		// TODO: handle finally clause
		closeConnections();
		
		
	}
	
	
}

}
