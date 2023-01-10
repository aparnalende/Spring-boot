package com.example.masai.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.masai.demo.model.Student;
@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{

}
	