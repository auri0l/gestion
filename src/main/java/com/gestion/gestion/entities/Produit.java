package com.gestion.gestion.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produit {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PRODUIT_ID")
	private int id;
	
	@Column(name = "PRODUIT_NAME")
	private String name;
	
	@Column(name = "PRODUIT_QUANTITY")
	private int Quantity;
	
	@Column(name = "PRODUIT_PRICE")
	private int price;
	
	
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
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Produit(int id, String name, int quantity, int price) {
		
		this.id = id;
		this.name = name;
		Quantity = quantity;
		this.price = price;
	}
	public Produit() {
	
	}
	
}
