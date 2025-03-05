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

import com.gestion.gestion.entities.Client;
import com.gestion.gestion.service.ClientService;


@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	

	private ClientService service ;
	
	@Autowired
	public ClientController(ClientService service) {
		this.service=service;
	}
	
	/**
	 * Get all {@Link Client}.
	 * 
	 * @return the list of {@Client}. otherwise {@Code null}
	 */
	@GetMapping
	 ResponseEntity<List<Client>>  getAllUser(){
		return ResponseEntity.ok(this.service.getClients());
	}
	
	/**
	 * Get Client by id
	 * 
	 * @param id - Client id
	 * @return {@Client}. otherwise {@null}
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable int id) {
		
		return ResponseEntity.ok(this.service.getClientById(id));
	}
	
	/**
	 * Delete Client by id
	 * 
	 * @param id - client id
	 * @return {@Client} delete.  otherwise {@null}
	 */
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		
		this.service.deleteClientById(id);
	}
	

	/**
	 * Save Client
	 * 
	 * @param client - Client
	 * @return {@Client} save.  otherwise {@null}
	 */
	@PostMapping
	public ResponseEntity<Client> save(@RequestBody Client client) {
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.saveClient(client));
		
	}
	
	/**
	 * Update {@Client} by id
	 * 
	 * @param id - Client id
	 * @param client - Client
	 * @return {@Client} updated. otherwise {@null}
	 */
	@PutMapping("{id}")
	public ResponseEntity<Client>  update(@PathVariable int id,@RequestBody Client client ) {
		
		return ResponseEntity.ok(this.service.updateClient(id, client));
	}
	

}



