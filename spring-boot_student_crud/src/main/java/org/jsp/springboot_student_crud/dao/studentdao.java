package org.jsp.springboot_student_crud.dao;

import java.util.List;

import org.jsp.springboot_student_crud.dto.Student;
import org.jsp.springboot_student_crud.repository.studentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class studentdao {
@Autowired
studentrepository repository;
	public void save(Student student) {
	repository.save(student);	
	}
	public void saveAll(List<Student> list) {
		repository.saveAll(list);
		}
	public Student findById(int id) 
	{
		return repository.findById(id).orElse(null);
	}
	public List<Student> findAll() 
	{
		return repository.findAll();
	}
	
	public List<Student> findByName(String name)
	{
		return repository.findByName(name);		
	}
	public List<Student> findByMobile(long mobile){
		return repository.findByMobile(mobile);
	}
	public List<Student> findByResult(String result){
		return repository.findByResult(result);
	}
	public List<Student> findBypercentageGreater(double per){
		return repository.findBypercentageGreaterThanEqual(per);
	}
	public List<Student> findBypercentageLesser(double per){
		return repository.findBypercentageLessThanEqual(per);
	}
	public List<Student> findByPercentageAndEnglish(double per,int marks){
		return repository.findByPercentageGreaterThanEqualAndEnglishGreaterThanEqual(per,marks);
	}
	public void delete(int id) {
		repository.deleteById(id);
	}
}
