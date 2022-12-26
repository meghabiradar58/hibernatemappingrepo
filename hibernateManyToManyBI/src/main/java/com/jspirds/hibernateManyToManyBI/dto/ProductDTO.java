package com.jspirds.hibernateManyToManyBI.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Data
@Table(name = "product_details")
public class ProductDTO {

	@Id
	@Column(name = "product_id")
	private int Id;
	@Column(name = "product_name")
	private String name;
	@Column(name = "product_category")
	private String Category;
	@Column(name = "product_price")
	private double price;
	@ManyToMany(mappedBy = "product")
	private List<CustomerDTO> customer;
	
}
