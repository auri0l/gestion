package com.gestion.gestion.service;

import java.util.List;

import com.gestion.gestion.entities.Invoice;



public interface IInvoiceService {
	
	public List<Invoice> getInvoices(); 
	
	public Invoice getInvoiceById(int id)  ;
	
	public void deleteInvoiceById(int id) ;
	
	public Invoice saveInvoice(Invoice invc);
	
	public Invoice updateInvoice(int id, Invoice invc) ;


}
