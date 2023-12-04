package org.jsp.springboot_student_crud.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Student {

	@Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
	String name;
	long mobile;
	String password;
	int english;
	int hindi;
	int kannada;
	double percentage;
	String result;
}
