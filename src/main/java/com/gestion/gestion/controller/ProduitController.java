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
import com.gestion.gestion.entities.Produit;
import com.gestion.gestion.service.ProduitService;


@RestController
@RequestMapping(value = "/produits")
public class ProduitController {
	
	private ProduitService service ;
	
	public ProduitController(ProduitService service) {
		this.service=service;
		
	}
	/**
	 * Get all {@Link Produit}.
	 * 
	 * @return the list of {@Produit}. otherwise {@Code null}
	 */
	@GetMapping
	 ResponseEntity<List<Produit>>  getAllUser(){
		return ResponseEntity.ok(this.service.getProduits());
	}
	
	/**
	 * Get Produit by id
	 * 
	 * @param id - Produit id
	 * @return {@Produit}. otherwise {@null}
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Produit> getProduitById(@PathVariable int id) {
		
		return ResponseEntity.ok(this.service.getProduitById(id));
	}
	
	/**
	 * Delete Produit by id
	 * 
	 * @param id - Produit id
	 * @return {@Produit} delete.  otherwise {@null}
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.service.deleteProduitById(id);
	}
	

	/**
	 * Save Produit
	 * 
	 * @param produit - Produit
	 * @return {@Produit} save.  otherwise {@null}
	 */
	@PostMapping
	public ResponseEntity<Produit> save(@RequestBody Produit produit) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.saveProduit(produit));
		
	}
	
	
	/**
	 * Update {@Produit} by id
	 * 
	 * @param id - Produit id
	 * @param produit - Produit
	 * @return {@Produit} updated. otherwise {@null}
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Produit>  update(@PathVariable int id,@RequestBody Produit produit ) {
		
		return ResponseEntity.ok(this.service.updateProduit(id, produit));
	}
	
	
	
}
