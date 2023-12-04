package org.jsp.springboot_student_crud.helper;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ResponseStructure<B> {
	 String message;
	    int status;
	    B data;
}
