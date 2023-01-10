package com.demo.aparna.project.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String phonenumber;

	private String address;

	private String opentime;

	private String closetime;

	private boolean flag = false;


	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String file;
	private String lastUpdatedTime;

	public Restaurant() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOpentime() {
		return opentime;
	}

	public void setOpentime(String opentime) {
		this.opentime = opentime;
	}

	public String getClosetime() {
		return closetime;
	}

	public void setClosetime(String closetime) {
		this.closetime = closetime;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getfile() {
		return file;
	}

	public void setfile(String file) {
		this.file = file;
	}

	public String getLastUpdatedTime() {
		return lastUpdatedTime;
	}

	public void setLastUpdatedTime(String lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}

	public Restaurant(Long id, String name, String phonenumber, String address, String opentime, String closetime,
			boolean flag, String file, String lastUpdatedTime) {
		super();
		this.id = id;
		this.name = name;
		this.phonenumber = phonenumber;
		this.address = address;
		this.opentime = opentime;
		this.closetime = closetime;
		this.flag = flag;
		this.file = file;
		this.lastUpdatedTime = lastUpdatedTime;
	}

	
}
