package com.jspirds.hibernateOneToOOne.dao;

import javax.persistence.EntityManager;

import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;

import com.jspirds.hibernateOneToOOne.dto.HusbandDto;
import com.jspirds.hibernateOneToOOne.dto.WifeDto;

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
		WifeDto wife=new WifeDto();
		wife.setId(1);
		wife.setName("Minakshi");
		wife.setContact(1254789632L);
	    wife.setAge(45);
		manager.persist(wife);
		
		HusbandDto husband=new HusbandDto();
		husband.setId(1);
		husband.setName("Prabhakar");
		husband.setAge(55);
		husband.setContact(5698745698L);
		manager.persist(husband);
		husband.setWife(wife);
		transaction.commit();
		
	} finally {
		CloseConnection();
	}
}

}
