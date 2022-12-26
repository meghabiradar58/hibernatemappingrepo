package com.jspirds.hibernateOneToOneBidirection.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;

import com.jspirds.hibernateOneToOneBidirection.dto.HusbandDto1;
import com.jspirds.hibernateOneToOneBidirection.dto.WifeDto1;

public class HusbandWifeDAO {
	
		private static EntityManagerFactory factory;
		private static EntityManager manager;
		private static EntityTransaction transaction;

		private static void OpenConnection()
		{
		factory=Persistence.createEntityManagerFactory("OneToOne");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();

		}
		private static void CloseConnection()
		{
		if(factory!=null)
		{
			factory.close();
			}
		if(manager!=null)
		{
			manager.close();
			}
		if(transaction!=null)
		{ 
			try {
			transaction.rollback();
			}catch (TransactionException e) {
				// TODO: handle exception
				System.out.println("Transaction commited");
				
			}
			}
			
		}
		public static void main(String[] args) {
			try {
				OpenConnection();
				transaction.begin();
				WifeDto1 wife=new WifeDto1();
				wife.setId(1);
				wife.setName("Mahi");
				wife.setContact(1254789632L);
			    wife.setAge(25);
			   
							
				HusbandDto1 husband=new HusbandDto1();
				husband.setId(1);
				husband.setName("jay");
				husband.setAge(26);
				husband.setContact(5698745698L);
				
				husband.setWife(wife);
				wife.setHusband(husband);
				manager.persist(wife);
				manager.persist(husband);
				transaction.commit();
				
			} finally {
				// TODO: handle finally clause
				CloseConnection();
			}
		}
}
