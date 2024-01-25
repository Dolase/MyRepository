package com.mydata.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mydata.mvc.entity.Student;
import com.mydata.mvc.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository sr;
	@Override
	public void saveStudent(Student s) {
	sr.save(s);	
	}

	@Override
	public void updateStudent(Student s) {
		sr.save(s);
	}

	@Override
	public void deleteStudent(int i) {
		sr.deleteById(i);
	}

	@Override
	public List<Student> viewAllStudent() {
		
		return sr.findAll();
	}

	@Override
	public Student viewAllStudentById(int i) {
				return sr.findById(i).get();
	}

}
