package org.jsp.springboot_student_crud.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataNotFoundException extends RuntimeException {
	String message="Data Not Found";
	
}
