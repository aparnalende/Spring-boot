package com.demo.aparna.project.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.demo.aparna.project.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
//	public Optional<Restaurant> findByFilenameAndId(String file, Long id);
	

	 @Query("SELECT p FROM Restaurant p WHERE " +
	            "p.name LIKE CONCAT('%',:resto, '%')" +
	            "Or p.address LIKE CONCAT('%', :resto, '%')"+"Or p.phonenumber LIKE CONCAT('%', :resto, '%')")
	 public List<Restaurant> searchRestaurant(String resto);


//	public Optional<Restaurant> findByRestaurantname(String name);
}
