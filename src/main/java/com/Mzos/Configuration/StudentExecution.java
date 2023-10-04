package com.Mzos.Configuration;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.Mzos.bean.Student;
import com.Mzos.exception.StudentNotFoundException;
import com.Mzos.service.StudentService;

public class StudentExecution {

	public static void main(String[] args) throws StudentNotFoundException {
		ApplicationContext  context= new AnnotationConfigApplicationContext(StudentConfig.class);
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("\n All Student Information");
	StudentService service=context.getBean(StudentService.class);
		service.searchAllStudent();
		
   
		System.out.println("Enter the new roll No,Name and Marks for adding new Student");
		service.addStudent(new Student(sc.nextInt(),sc.next(),sc.nextFloat()));
		service.searchAllStudent();
		
		
		System.out.println("Enter Student Marks for updating");
		service.updateStudent(new Student(2,"Gunjan",sc.nextFloat()));
		service.searchAllStudent();
	}

}
