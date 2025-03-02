package com.gestion.gestion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestion.gestion.entities.User;
import com.gestion.gestion.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	
	
	private UserService service ;
	
	@Autowired
	public UserController(UserService service) {
		this.service=service;
	}
	
	/**
	 * Get all {@Link User}.
	 * 
	 * @return the list of {@User}. otherwise {@Code null}
	 */
	@GetMapping
	 ResponseEntity<List<User>>  getAllUser(){
		return ResponseEntity.ok(this.service.getUsers());
	}
	
	/**
	 * Get User by id
	 * 
	 * @param id - User id
	 * @return {@User}. otherwise {@null}
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> getUsertById(@PathVariable int id) {
		
		return ResponseEntity.ok(this.service.getUserById(id));
	}
	
	/**
	 * Delete User by id
	 * 
	 * @param id - user id
	 * @return {@User} delete.  otherwise {@null}
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.service.deleteUserById(id);
	}
	

	/**
	 * Save User
	 * 
	 * @param user - User
	 * @return {@User} save.  otherwise {@null}
	 */
	@PostMapping
	public ResponseEntity<String>  save(@RequestBody User user) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.saveUser(user));
		
	}
	
	/**
	 * Update {@User} by id
	 * 
	 * @param id - User id
	 * @param user - User
	 * @return {@User} updated. otherwise {@null}
	 */
	@PutMapping("/{id}")
	public ResponseEntity<User>  update(@PathVariable int id,@RequestBody User user ) {
		
		return ResponseEntity.ok(this.service.updateUser(id, user));
	}
	
	/**
	 * Acitvate User Acount {@User} by token.
	 * 
	 * @param token - User Active key
	 */
	@GetMapping("/activate/{token}")
	public ResponseEntity<String>  activateAcount(@PathVariable String token) {
		boolean activate = this.service.activate(token);
		if (activate) {
			return ResponseEntity.ok("Account successfully Activate");
		} else {
			return ResponseEntity.ok("The token used is not the right token");
		}
	}
	

}
