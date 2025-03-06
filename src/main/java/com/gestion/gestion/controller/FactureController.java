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

import com.gestion.gestion.entities.Facture;
import com.gestion.gestion.service.FactureService;

@RestController
@RequestMapping(value = "/facture")
public class FactureController {
	
	private FactureService service;

	public FactureController(FactureService service) {
		this.service = service;
	}
	
	/**
	 * Get all {@Link Facture}.
	 * 
	 * @return the list of {@Facture}. otherwise {@Code null}
	 */
	@GetMapping
	 ResponseEntity<List<Facture>>  getAllUser(){
		return ResponseEntity.ok(this.service.getFactures());
	}
	
	/**
	 * Get Facture by id
	 * 
	 * @param id - Facture id
	 * @return {@Facture}. otherwise {@null}
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Facture> getFactureById(@PathVariable int id) {
		
		return ResponseEntity.ok(this.service.getFactureById(id));
	}
	
	/**
	 * Delete Facture by id
	 * 
	 * @param id - Facture id
	 * @return {@Facture} delete.  otherwise {@null}
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.service.deleteFactureById(id);
	}
	

	/**
	 * Save Facture
	 * 
	 * @param facture - Facture
	 * @return {@Facture} save.  otherwise {@null}
	 */
	@PostMapping
	public ResponseEntity<Facture> save(@RequestBody Facture facture) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.saveFacture(facture));
		
	}
	
	
	/**
	 * Update {@Facture} by id
	 * 
	 * @param id - Facture id
	 * @param facture - Facture
	 * @return {@Facture} updated. otherwise {@null}
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Facture>  update(@PathVariable int id,@RequestBody Facture facture ) {
		
		return ResponseEntity.ok(this.service.updateFacture(id, facture));
	}
	
	
	
	

}
