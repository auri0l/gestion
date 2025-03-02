package com.gestion.gestion.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Client {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENT_ID")
	private int id;
	
	@Column(name = "CLIENT_NAME")
	private String name ;
	
	@Column(name = "CLIENT_ADRESS")
	private String adress;
	
	@Column(name = "CLIENT_PHONE")
	private String phone;
	
	@Column(name = "CLIENT_AGE")
	private int age;
	
	@Column(name = "CLIENT_SEX")
	private char sex;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public Client(int id, String name, String adress, String phone, int age, char sex) {
	
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.phone = phone;
		this.age = age;
		this.sex = sex;
	}
	public Client() {
	}
	
	
	

}
