package com.gestion.gestion.controller;

import java.util.List;

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

import com.gestion.gestion.entities.Invoice;
import com.gestion.gestion.service.InvoiceService;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {
	
	private InvoiceService service;

	public InvoiceController(InvoiceService service) {
		this.service = service;
	}
	
	/**
	 * Get all {@Link Invoice}.
	 * 
	 * @return the list of {@Invoice}. otherwise {@Code null}
	 */
	@GetMapping
	 ResponseEntity<List<Invoice>>  getAllInvoice(){
		return ResponseEntity.ok(this.service.getInvoices());
	}
	
	/**
	 * Get Invoice by id
	 * 
	 * @param id - Invoice id
	 * @return {@Invoice}. otherwise {@null}
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Invoice> getInvoiceById(@PathVariable int id) {
		
		return ResponseEntity.ok(this.service.getInvoiceById(id));
	}
	
	/**
	 * Delete Invoice by id
	 * 
	 * @param id - Invoice id
	 * @return {@Invoice} delete.  otherwise {@null}
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.service.deleteInvoiceById(id);
	}
	

	/**
	 * Save Invoice
	 * 
	 * @param invoice - Invoice
	 * @return {@Invoice} save.  otherwise {@null}
	 */
	@PostMapping
	public ResponseEntity<Invoice> save(@RequestBody Invoice invoice) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.saveInvoice(invoice));
		
	}
	
	
	/**
	 * Update {@Invoice} by id
	 * 
	 * @param id - Invoice id
	 * @param invoice - Invoice
	 * @return {@Invoice} updated. otherwise {@null}
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Invoice>  update(@PathVariable int id,@RequestBody Invoice invoice ) {
		
		return ResponseEntity.ok(this.service.updateInvoice(id, invoice));
	}
	
	
	
	

}
