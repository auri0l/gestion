package com.gestion.gestion.service;

import java.util.List;

import com.gestion.gestion.entities.User;


public interface IUserService {
	
	public List<User> getUsers(); 
	
	public User getUserById(int id)  ;
	
	public void deleteUserById(int id) ;
	
	public String saveUser(User us);
	
	public User updateUser(int id, User us) ;
	
	public boolean activate(String token) ;
}
