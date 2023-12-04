package org.jsp.springboot_student_crud.service;

import java.util.List;

import org.jsp.springboot_student_crud.dao.studentdao;
import org.jsp.springboot_student_crud.dto.Student;
import org.jsp.springboot_student_crud.exception.DataNotFoundException;
import org.jsp.springboot_student_crud.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
@Service
public class studentservice {
	@Autowired
studentdao dao;
	@Autowired
	ResponseStructure<Student> structure1;
	
	@Autowired
	ResponseStructure<List<Student>> structure2;
	
	public ResponseStructure save(Student student) {	
		student.setPercentage(student.getEnglish() + student.getHindi()+ student.getKannada());
    	student.setPercentage((student.getEnglish() + student.getHindi()+ student.getKannada()) / 3.0);
		if (student.getEnglish() < 35 || student.getHindi() < 35 || student.getKannada() < 35
				|| student.getPercentage() < 35)
			student.setResult("Fail");
		else {
			if (student.getPercentage() >= 85)
				student.setResult("Distinction");
			else if (student.getPercentage() >= 60)
				student.setResult("FirstClass");
			else
				student.setResult("SecondClass");
		}
		dao.save(student);
		structure1.setData(student);
		structure1.setStatus(HttpStatus.CREATED.value());
		structure1.setMessage("Data Saved Successfully");
		return structure1;
    }
	public ResponseStructure<List<Student>> saveAll(List<Student> students) {	
		for(Student student:students) {
		student.setPercentage(student.getEnglish() + student.getHindi()+ student.getKannada());
    	student.setPercentage((student.getEnglish() + student.getHindi()+ student.getKannada()) / 3.0);
		if (student.getEnglish() < 35 || student.getHindi() < 35 || student.getKannada() < 35
				|| student.getPercentage() < 35)
			student.setResult("Fail");
		else {
			if (student.getPercentage() >= 85)
				student.setResult("Distinction");
			else if (student.getPercentage() >= 60)
				student.setResult("FirstClass");
			else
				student.setResult("SecondClass");
		}
		}
		dao.saveAll(students);
		structure2.setData(students);
		structure2.setStatus(HttpStatus.CREATED.value());
		structure2.setMessage("Data Saved Successfully");
		return structure2;
    }

	public ResponseStructure findById(int id) 
	{
        Student student = dao.findById(id);
        if(student == null) 
        {
        	throw new DataNotFoundException("data not found with id");
//        	structure1.setData(null);
//    		structure1.setStatus(HttpStatus.NOT_FOUND.value());
//    		structure1.setMessage("Data Not Found With The Id :"+id);	
        }
        else
        {
        	structure1.setData(student);
    		structure1.setStatus(HttpStatus.FOUND.value());
    		structure1.setMessage("Data Found & Count : 1");	
        }
		return structure1;
	}

	public ResponseStructure<List<Student>> findAll() 
	{
		List<Student> list = dao.findAll();
		if(list.isEmpty()) 
			throw new DataNotFoundException("Data Not Found");
//		{        
//        	structure2.setData(null);
//    		structure2.setStatus(HttpStatus.NOT_FOUND.value());
//    		structure2.setMessage("Data Not Found");	
//        }
        else
        {
        	structure2.setData(list);
    		structure2.setStatus(HttpStatus.FOUND.value());
    		structure2.setMessage("Data Found & Count :" + list.size());	
        }
		return structure2;		
	}

	public ResponseStructure<List<Student>> findByName(String name) 
	{
		List<Student> list = dao.findByName(name);
		if(list.isEmpty()) 
			throw new DataNotFoundException("Data Not Found With The Name :" +name);
//		{        
//        	structure2.setData(null);
//    		structure2.setStatus(HttpStatus.NOT_FOUND.value());
//    		structure2.setMessage("Data Not Found With The Name :" +name);	
//        }
        else
        {
        	structure2.setData(list);
    		structure2.setStatus(HttpStatus.FOUND.value());
    		structure2.setMessage("Data Found & Count :" + list.size());	
        }
		return structure2;		
	}
	public ResponseStructure<List<Student>> findByMobile(long mobile) 
	{
		List<Student> list = dao.findByMobile(mobile);
		if(list.isEmpty()) 
			throw new DataNotFoundException("Data Not Found With The Moble Number :" +mobile);
//		{        
//        	structure2.setData(null);
//    		structure2.setStatus(HttpStatus.NOT_FOUND.value());
//    		structure2.setMessage("Data Not Found With The Moble Number :" +mobile);	
//        }
        else
        {
        	structure2.setData(list);
    		structure2.setStatus(HttpStatus.FOUND.value());
    		structure2.setMessage("Data Found & Count :" + list.size());	
        }
		return structure2;
	}
	public ResponseStructure<List<Student>> findByResult(String result){
		List<Student> list = dao.findByResult(result);
		if(list.isEmpty()) 
			throw new DataNotFoundException("Data Not Found With The Result :\" + result");
//		{        
//        	structure2.setData(null);
//    		structure2.setStatus(HttpStatus.NOT_FOUND.value());
//    		structure2.setMessage("Data Not Found With The Result :" + result);	
//        }
        else
        {
        	structure2.setData(list);
    		structure2.setStatus(HttpStatus.FOUND.value());
    		structure2.setMessage("Data Found & Count :" + list.size());	
        }
		return structure2;
	}
	public ResponseStructure<List<Student>> fetchByPercentageGreater(double per) 
	{
		List<Student> list = dao.findBypercentageGreater(per);
		if(list.isEmpty()) 
			throw new DataNotFoundException("Data Not Found With percentage greater :\" + per");
//		{        
//        	structure2.setData(null);
//    		structure2.setStatus(HttpStatus.NOT_FOUND.value());
//    		structure2.setMessage("Data Not Found With percentage greater :" + per);	
//        }
        else
        {
        	structure2.setData(list);
    		structure2.setStatus(HttpStatus.FOUND.value());
    		structure2.setMessage("Data Found & Count :" + list.size());	
        }
		return structure2;
	}
	public ResponseStructure<List<Student>> fetchByPercentageLesser(double per) 
	{
		List<Student> list = dao.findBypercentageLesser(per);
		if(list.isEmpty()) 
			throw new DataNotFoundException("Data Not Found With percentage lesser :\" + per");
//		{        
//        	structure2.setData(null);
//    		structure2.setStatus(HttpStatus.NOT_FOUND.value());
//    		structure2.setMessage("Data Not Found With percentage lesser :" + per);	
//        }
        else
        {
        	structure2.setData(list);
    		structure2.setStatus(HttpStatus.FOUND.value());
    		structure2.setMessage("Data Found & Count :" + list.size());	
        }
		return structure2;
	}
	public ResponseStructure<List<Student>> fetchByPercentageEnglish(double per,int marks) 
	{
		List<Student> list = dao.findByPercentageAndEnglish(per,marks);
		if(list.isEmpty()) 
			throw new DataNotFoundException("Data Not Found With percentage english :\" + per");
//		{        
//        	structure2.setData(null);
//    		structure2.setStatus(HttpStatus.NOT_FOUND.value());
//    		structure2.setMessage("Data Not Found With percentage english :" + per);	
//        }
        else
        {
        	structure2.setData(list);
    		structure2.setStatus(HttpStatus.FOUND.value());
    		structure2.setMessage("Data Found & Count :" + list.size());	
        }
		return structure2;
	}
	public ResponseStructure<Student> deleteById(int id){
		Student student=dao.findById(id);
	if(student==null) 
		throw new DataNotFoundException("Data Not Found With id:" +id);
//		{
//			structure1.setData(null);
//			structure1.setStatus(HttpStatus.NOT_FOUND.value());
//			structure1.setMessage("data not found ith id:"+id);
//		}
		else {
			structure1.setData(student);
			dao.delete(id);
			structure1.setMessage("Data Deleted");
			structure1.setStatus(HttpStatus.OK.value());
		}
		return structure1;
	}
	public ResponseStructure update(Student student) {	
		student.setPercentage(student.getEnglish() + student.getHindi()+ student.getKannada());
    	student.setPercentage((student.getEnglish() + student.getHindi()+ student.getKannada()) / 3.0);
		if (student.getEnglish() < 35 || student.getHindi() < 35 || student.getKannada() < 35
				|| student.getPercentage() < 35)
			student.setResult("Fail");
		else {
			if (student.getPercentage() >= 85)
				student.setResult("Distinction");
			else if (student.getPercentage() >= 60)
				student.setResult("FirstClass");
			else
				student.setResult("SecondClass");
		}
		dao.save(student);
		structure1.setData(student);
		structure1.setStatus(HttpStatus.CREATED.value());
		structure1.setMessage("Data Saved Successfully");
		return structure1;
    }
}