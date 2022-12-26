package com.jspirds.hibernateOneToOOne.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity

@Data
public class HusbandDto {
	@Id
	private int Id;
	private String Name;
	private int age;
	private long contact;
	@OneToOne
	private WifeDto wife;
	
	

}
