package com.jspirds.hibernateManyToOne1.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Entity
@Data

public class CompanyDTO {
	@Id
	private int id;
	private String name;
	private String email;
	private String city;
	
}
