package com.jspirds.hibernateOneToMany.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class FatherDTO {
@Id
private int Id;
private String Name;
private int age;
@OneToMany
private List<ChildDTO> children;

}
