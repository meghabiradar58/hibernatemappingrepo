package com.jspirds.hibernateManyToManyUni.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;

import com.jspirds.hibernateManyToManyUni.dto.customerdto;
import com.jspirds.hibernateManyToManyUni.dto.productdto;



public class customerproductdao {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static void OpenConnection()
	{
	factory=Persistence.createEntityManagerFactory("ManyToMany");
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
			
			customerdto customer1=new customerdto();
			customer1.setId(1);
			customer1.setName("Megha");
			customer1.setEmail("megha21@gmail.com");
			
			customerdto customer2=new customerdto();
			customer2.setId(2);
			customer2.setName("Manvi");
			customer2.setEmail("manvi1@gmail.com");
			
			customerdto customer3=new customerdto();
			customer3.setId(3);
			customer3.setName("jaya");
			customer3.setEmail("jaya@gmail.com");
		
			productdto product1=new productdto();
			product1.setId(1);
			product1.setName("shoes");
			product1.setPrice(1232.00);
			product1.setCategory("sports");
			
			productdto product2=new productdto();
			product2.setId(2);
			product2.setName("Tshirt");
			product2.setPrice(932.99);
			product2.setCategory("Clothing");
			
			productdto product3=new productdto();
			product3.setId(3);
			product3.setName("Watch");
			product3.setPrice(4932.99);
			product3.setCategory("accessries");
			
			List<productdto> products=Arrays.asList(product1,product2,product3);
			
			customer1.setProducts(products);
			customer2.setProducts(products);
			customer3.setProducts(products);
			
			
			manager.persist(customer1);
			manager.persist(customer2);
			manager.persist(customer3);
			manager.persist(product1);
			manager.persist(product2);
			manager.persist(product3);
			transaction.commit();
			
		} finally {
			// TODO: handle finally clause
			CloseConnection();
		}
	}
}
