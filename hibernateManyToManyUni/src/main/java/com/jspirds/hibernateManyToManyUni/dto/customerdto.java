package com.jspirds.hibernateManyToManyUni.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class customerdto {
	@Id
	private int Id;
	private String name;
	private String email;
	
	
@ManyToMany
private List<productdto> products;

	
}
