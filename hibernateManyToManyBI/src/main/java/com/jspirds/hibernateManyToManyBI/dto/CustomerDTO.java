package com.jspirds.hibernateManyToManyBI.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

import lombok.Data;
@Entity
@Data
@Table(name = "Customer_details")
public class CustomerDTO {
	@Id
	@Column(name = "customer_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@Column(name = "customer_name")
	private String name;
	@Column(name = "customer_email")
	private String email;
	
	
@ManyToMany
@JoinTable(name = "customers_products",joinColumns = @JoinColumn(referencedColumnName 
		= "customer_Id"),
inverseJoinColumns = @JoinColumn(referencedColumnName = "product_id"))

private List<ProductDTO> product;
}
