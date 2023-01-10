package com.demo.aparna.project.service;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.aparna.project.model.Restaurant;
import com.demo.aparna.project.repository.RestaurantRepository;
import org.springframework.util.StringUtils;
@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public Restaurant addResto(Restaurant resto) {
		Date d = new Date();
		String date = d.toString();
		resto.setLastUpdatedTime(date.substring(4));
		Restaurant saveResto = restaurantRepository.save(resto);

		return saveResto;
	}
	
//	@Override
//	public Restaurant addResto(Restaurant resto,MultipartFile file)
//	{
//		Restaurant p = new Restaurant();
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		if(fileName.contains(".."))
//		{
//			System.out.println("not a a valid file");
//		}
//		try {
//			p.setfile(Base64.getEncoder().encodeToString(file.getBytes()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//        System.out.println("Resto"+resto);
//        restaurantRepository.save(p);
//        return p;
//	}


	@Override
	public Optional<Restaurant> getResto(Long id) {
		Optional<Restaurant> getRest = restaurantRepository.findById(id);
		return getRest;
	}

	@Override
	public List<Restaurant> getAllResto() {
		List<Restaurant> list = restaurantRepository.findAll();
		return list;
	}

	@Override
	public Restaurant updateResto(Restaurant resto) {

		Date d = new Date();
		String date = d.toString();
		resto.setLastUpdatedTime(date.substring(4));
		Restaurant rest = restaurantRepository.save(resto);
		return rest;
	}

	@Override
	public void deleteResto(Long id) {
		restaurantRepository.deleteById(id);

	}

	@Override
	public List<Restaurant> searchRestaurant(String resto){
		List<Restaurant> restaurant=restaurantRepository.searchRestaurant(resto);
		return restaurant;
	}
//	@Override
//	public String uploadImage(MultipartFile file, Long id) {
//
//		Optional<Restaurant> restData = restaurantRepository.findById(id);
//		try {
//			if (restData.isPresent()) {
//				Restaurant restModel = restData.get();
//				restModel.setFilename(file.getOriginalFilename());
//				restModel.setMimetype(file.getContentType());
//				restModel.setPic(file.getBytes());
//
//				restaurantRepository.save(restModel);
//
//			}
//			System.out.println("File uploaded successfully! -> filename = " + file.getOriginalFilename());
//			return "File uploaded successfully! -> filename = " + file.getOriginalFilename();
//		} catch (Exception e) {
//			return "FAIL! Maybe You had uploaded the file before or the file's size > 500KB";
//		}
//
//	}


	@Override
	public String uploadImage(MultipartFile file, Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
