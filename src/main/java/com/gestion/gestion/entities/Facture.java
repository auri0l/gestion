package com.gestion.gestion.entities;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Facture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "FACTURE_ID")
	private int id;
	
	@Column(name = "FACTURE_DATE")
	private Date date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Facture(int id, Date date) {
		
		this.id = id;
		this.date = date;
	}
	public Facture() {
	
	}
	

}
