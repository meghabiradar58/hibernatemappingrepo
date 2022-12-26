package com.jspirds.hibernateOneToOOne.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity
@Data
public class WifeDto {
	@Id
	private int Id;
	private String Name;
	private int age;
	private long contact;
	}
