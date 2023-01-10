package com.example.blogproject.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.blogproject.entities.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

//	@Query("select * from categories")
	 List<Category> findAll();
	 
//	 List<Category> findAllById();

}
