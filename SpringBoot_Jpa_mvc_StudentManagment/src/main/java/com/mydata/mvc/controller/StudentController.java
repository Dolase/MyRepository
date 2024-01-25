package com.mydata.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mydata.mvc.entity.Student;
import com.mydata.mvc.service.StudentService;

@Controller
@RequestMapping(path = "/")
public class StudentController {

	@Autowired
	StudentService ss;

	public void setSs(StudentService ss) {
		this.ss = ss;
	}
	
	@GetMapping("/viewallstudents")
	public String listStudents(Model model) {
		model.addAttribute("students", ss.viewAllStudent());
		return "Student";
	}
	
	@RequestMapping(path = "/openstudentform")
	public String openAddStudentForm(Model m)
	{
		Student s=new Student();
		m.addAttribute("student",s);
		return "AddStudent";
		
	}
	
	@RequestMapping(path = "/savestudent")
	public String saveStudentObj(@ModelAttribute Student student)
	{
		ss.saveStudent(student);
		return "Student";
	}
	
	@GetMapping(path ="/openUpdateS/{id}")
	public String openUpdateStudentForm(@PathVariable int id,Model m)
	{
		m.addAttribute("student",ss.viewAllStudentById(id));
		return "UpdateStudent";
		
	}
	
	@PostMapping(path="/updateStudent/{id}")
	public String updateStudentObj(@PathVariable int id,@ModelAttribute Student student,Model model)
	{
		Student es=ss.viewAllStudentById(id);
		es.setId(id);
		es.setFirstName(student.getFirstName());
		es.setLastName(student.getLastName());
		es.setEmail(student.getEmail());
		
		ss.updateStudent(es);
		
		return "Student";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		ss.deleteStudent(id);
		return "Student";
	}
	}
	

