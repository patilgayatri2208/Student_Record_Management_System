package com.Mzos.service;

import org.springframework.stereotype.Service;

import com.Mzos.bean.Student;
import com.Mzos.deo.StudentRepository;
import com.Mzos.exception.StudentNotFoundException;

@Service
public class StudentService {
	StudentRepository repo=new StudentRepository();
	
	 public void addStudent(Student stud)
	 {
		 System.out.println("Student Added "+repo.insertStudent(stud));
	 }
	  
	 
	 public void searchStudent(int rollNo)
	 {
		 System.out.println("Student Search is "+repo.selectStudent(rollNo));
	 }
	 
	 public void searchAllStudent()
	 {
		 repo.searchAllStudent().forEach(stud->System.out.println(stud));
	 }
	 
	 public void deleteStudent(int rollNo)
	 {
		 repo.deleteStudent(rollNo);
	 }
			 
	 public void updateStudent(Student stud) throws StudentNotFoundException
	 {
		 System.out.println("Updated Student is "+repo.updateStudent(stud));
	 }
	 
}

















