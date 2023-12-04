package org.jsp.springboot_student_crud.exception;

import org.jsp.springboot_student_crud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {
	@Autowired
	ResponseStructure<String> structure;
	@ExceptionHandler(DataNotFoundException.class)
public ResponseStructure<String> handle(DataNotFoundException exception){
	structure.setStatus(HttpStatus.NOT_FOUND.value());
	structure.setData(exception.getMessage());
	structure.setMessage("data not found");
	return structure;
}
}
