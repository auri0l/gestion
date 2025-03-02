package com.gestion.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestion.gestion.entities.Client;
import com.gestion.gestion.respository.ClientRepository;

@Service
public class ClientService implements IClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	



	@Override
	public List<Client> getClients() {
		
		return this.clientRepository.findAll();
	}

	@Override
	public Client getClientById(int id) {
		Optional<Client> client = this.clientRepository.findById(id);
		if (client != null) {
			return client.get();
		}
		return null;	
	}

	@Override
	public void deleteClientById(int id) {
	
		Optional<Client> client = this.clientRepository.findById(id);
		if (client != null) {
			this.clientRepository.delete(client.get());
		}	
		
	}

	@Override
	public Client saveClient(Client cl) {
		return this.clientRepository.save(cl);
	}

	@Override
	public Client updateClient(int id, Client cl) {
		
		Optional<Client> c = this.clientRepository.findById(id);
		if (c.isPresent() && id == cl.getId()) {
			return this.clientRepository.save(cl);
		}
		return null;
	}

}
