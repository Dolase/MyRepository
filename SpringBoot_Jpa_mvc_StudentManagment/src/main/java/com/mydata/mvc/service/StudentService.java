package com.mydata.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mydata.mvc.entity.Student;
import com.mydata.mvc.repository.StudentRepository;

public interface StudentService {

  public void saveStudent(Student s);
  public void updateStudent(Student s);
  public void deleteStudent(int i);
  public List<Student> viewAllStudent();
  public Student viewAllStudentById(int i);

}
