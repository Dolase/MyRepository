package com.mydata.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mydata.mvc.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
