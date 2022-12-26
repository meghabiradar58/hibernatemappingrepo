package com.jspirds.hibernateOneToOneBidirection.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity
@Data
public class WifeDto1 {
	@Id
	private int Id;
	private String Name;
	private int age;
	private long contact;
	@OneToOne
	private HusbandDto1 husband;
}
