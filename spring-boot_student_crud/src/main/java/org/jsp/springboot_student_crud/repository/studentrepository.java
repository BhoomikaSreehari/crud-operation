package org.jsp.springboot_student_crud.repository;

import java.util.List;

import org.jsp.springboot_student_crud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface studentrepository extends JpaRepository<Student,Integer> {
List<Student> findByName(String name);

List<Student> findByMobile(long mobile);

List<Student> findByResult(String result);

List<Student> findBypercentageGreaterThanEqual(double per);

List<Student> findBypercentageLessThanEqual(double per);

//@Query("select x from student x where percentage>=? ")
//List<Student> findBypercentageGreaterThanEqualAndEnglishGreaterThanEqual(double per, int marks);

List<Student> findByPercentageGreaterThanEqualAndEnglishGreaterThanEqual(double per, int marks);
}
