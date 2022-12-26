package com.jspirds.hibernateOneToMany.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data

public class ChildDTO {
@Id
private int Id;
private String Name;
private int age;

}
