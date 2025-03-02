package com.gestion.gestion.service;

import java.util.List;

import com.gestion.gestion.entities.Client;


public interface IClientService {

	
public List<Client> getClients(); 
	
	public Client getClientById(int id)  ;
	
	public void deleteClientById(int id) ;
	
	public Client saveClient(Client cl);
	
	public Client updateClient(int id, Client cl) ;
}
