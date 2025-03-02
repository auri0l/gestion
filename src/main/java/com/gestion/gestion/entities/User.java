package com.gestion.gestion.entities;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int id;
	
	@Column(name = "USER_USERNAME")
	private String username;
	
	@Column(name = "USER_EMAIL")
	private String email;
	
	@Column(name = "USER_PASSWORD")
	private String password;
	
	@Column(name = "USER_ACTIVE")
	private boolean active;
	
	@Column(name = "USER_ACTIVEKEY")
	private String activeKey;
	
	@ManyToAny(fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(name="role_id"),
			inverseJoinColumns = @JoinColumn(name="user_id"))
	private Set<Role> role = new HashSet<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public String getActiveKey() {
		return activeKey;
	}
	public void setActiveKey(String activeKey) {
		this.activeKey = activeKey;
	}
	
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	public User(String username, String email, String password, boolean active, String activeKey) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.active = active;
		this.activeKey = activeKey;
	}
	public User() {
		super();
	}

}
