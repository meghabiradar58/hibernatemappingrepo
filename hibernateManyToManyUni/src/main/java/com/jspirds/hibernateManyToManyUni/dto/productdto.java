package com.jspirds.hibernateManyToManyUni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class productdto {
	@Id
	private int Id;
	private String name;
	private String Category;
	private double price;
	
}
