package com.Mzos.deo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.Mzos.bean.Student;
import com.Mzos.exception.StudentNotFoundException;

@Repository
public class StudentRepository 
{
	ArrayList<Student> list=new ArrayList<>(Arrays.asList(new Student(1,"Gayatri",98),new Student(2,"Gunjan",67),new Student(3,"Krishna",88)));
	
	public boolean insertStudent(Student stud)
	{
		return list.add(stud);
	}  
	 
	public Student selectStudent(int rollNo)
	{
		List<Student> find= list.stream().filter(emp->{return emp.getRollNo()==rollNo;}).collect(Collectors.toList());
		return find.get(0);
		
	}
	
	public List<Student> searchAllStudent()
	{
		return list;
	}
	
	public Student updateStudent(Student Stud) throws StudentNotFoundException
	{
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getRollNo()==Stud.getRollNo())
			{
				return list.set(i, Stud);
			}
		}
	   throw new StudentNotFoundException("Student having Roll no "+Stud.getRollNo()+" Not Found");
		
	}
	
	public void deleteStudent(int rollNo)
	{
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getRollNo()==rollNo)
				list.remove(i);
		}
	}

}
	 