package org.jsp.springboot_student_crud.controller;

import java.util.List;

import org.jsp.springboot_student_crud.dto.Student;
import org.jsp.springboot_student_crud.helper.ResponseStructure;
import org.jsp.springboot_student_crud.service.studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
@RestController
@RequestMapping("/students")
public class studentcontroller {
	@Autowired
	studentservice service;
//	save one record
	@PostMapping
	@Operation(summary="save one record")
    public ResponseStructure<Student> saveStudent(@RequestBody Student student) 
    {
	     return service.save(student);
    }
//	save multiple record
	@PostMapping("/all")
	@Operation(summary="save multiple record")
	public ResponseStructure<List<Student>> saveAll(@RequestBody List<Student> students){
		return service.saveAll(students);
	}
//	method 1 fetch by id
	
	 public ResponseStructure<Student> fetchById(@RequestParam int id){
		 return service.findById(id);
	 }
//	 method 2 fetch by id
    @GetMapping("/id/{id}")
    @Operation(summary="save by id")
    public ResponseStructure<Student> findById(@PathVariable int id)
    { 	
		return service.findById(id);   	
    }
//    fetchall
    @GetMapping("/all")
    public ResponseStructure<List<Student>> fetchAll()
    {
    	return service.findAll();
 }
// fetch by name    
    @GetMapping("/name/{name}")
    public ResponseStructure<List<Student>> fetchByName(@PathVariable String name)
    {
		return service.findByName(name);	
    }
//    fetch by mobile number
    @GetMapping("/mobile/(mobile)")
    public ResponseStructure<List<Student>> findByMobile(@PathVariable long mobile){
    	return service.findByMobile(mobile);
    }
//    fetch by result
    @GetMapping("/result/(res)")
    public ResponseStructure<List<Student>> findByResult(@PathVariable String res){
    	return service.findByResult(res);
    }
//    fetch by percentage greater
    @GetMapping("/percentage/greater/(per)")
    public ResponseStructure<List<Student>> findPercentageGreater(@PathVariable double per)
    {
    	return service.fetchByPercentageGreater(per);
    }
//    fetch by percentage lesser
    @GetMapping("/percentage/lesser/(per)")
    public ResponseStructure<List<Student>> findPercentageLesser(@PathVariable double per)
    {
    	return service.fetchByPercentageLesser(per);
    }
//    fetch by english percentage
    @GetMapping("/percentage/(per)/english/(marks)")
    public ResponseStructure<List<Student>> fetchPercentageAndEnglish(@PathVariable double per)
    {
    	return service.fetchByPercentageEnglish(per, 0);
    }
  //Delete By Id
    @DeleteMapping("/id/{id}")
    public ResponseStructure<Student> deleteById(@PathVariable int id)
    {
    	return service.deleteById(id);
    }   
    //Edit Record
    @PutMapping
    public ResponseStructure<Student> updateStudent(@PathVariable Student student)
    {
    	return service.update(student);
    }
}