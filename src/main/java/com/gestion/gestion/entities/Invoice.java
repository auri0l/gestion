package com.gestion.gestion.entities;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "INVOICE_ID")
	private int id;
	
	@Column(name = "INVOICE_DATE")
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
	public Invoice(int id, Date date) {
		
		this.id = id;
		this.date = date;
	}
	public Invoice() {
	
	}
	

}
