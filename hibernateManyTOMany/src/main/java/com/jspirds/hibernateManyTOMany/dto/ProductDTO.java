package com.jspirds.hibernateManyTOMany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class ProductDTO {
	@Id
	private int Id;
	private String name;
	private String Category;
	private double price;
	@ManyToMany
	private List<CustomerDTO> customer;
	
	
	

}
