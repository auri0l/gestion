package com.gestion.gestion.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestion.entities.Role;
import com.gestion.gestion.entities.User;
import com.gestion.gestion.respository.RoleRepository;
import com.gestion.gestion.respository.UserRepository;


@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private EmailService emailService;

	public UserService(UserRepository userRepository, RoleRepository roleRepository, EmailService emailService) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.emailService = emailService;
	}


	@Override
	public List<User> getUsers() {
		return this.userRepository.findAll();
	}


	@Override
	public User getUserById(int id) {
		Optional<User> user = this.userRepository.findById(id);
		if (user != null) {
			return user.get();
		}
		return null;	
	}

	@Override
	public void deleteUserById(int id) {
		Optional<User> user = this.userRepository.findById(id);
		if (user != null) {
			this.userRepository.delete(user.get());
		}	
	}

	@Override
	public String saveUser(User user) {
		Set<Role> roles = user.getRole();
		Set<Role> rolesAdded = new HashSet<>();
		if (roles.size() > 0) {
			for (Role role : roles) {
				Optional<Role> r = roleRepository.findByName(role.getName());
				if (r.isPresent()) {
					rolesAdded.add(role);
				}
			}
			
		}
		user.setRole(rolesAdded);
		user.setActiveKey(UUID.randomUUID().toString());
		this.userRepository.save(user);
		
		String activeLink = "http://localhost:8080/users/activate/"+user.getActiveKey();
		emailService.sendSimpleMessage(user.getEmail(), "Activate your Acount", 
				"Welcome"+user.getUsername()+" \n\n Please clink on the link below to activate your acount. \n\n"+activeLink);
		
		return "User create successfully told to the user to check here email.";
	}

	@Override
	public User updateUser(int id, User user) {
		Optional<User> u = this.userRepository.findById(id);
		if (u.isPresent() && id == user.getId()) {
			return this.userRepository.save(user);
		}
		return null;	
	}


	@Override
	public boolean activate(String token) {
		Optional<User> user = this.userRepository.findByActiveKey(token);
		if (user.isPresent()) {
			User u = user.get();
			u.setActive(true);
			u.setActiveKey(null);
			this.userRepository.save(u);
			return true;
		}
		return false;
	}

}



