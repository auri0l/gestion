package com.gestion.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gestion.gestion.entities.Facture;
import com.gestion.gestion.respository.FactureRepository;

@Service
public class FactureService implements IFactureService {

	private FactureRepository factureRepository;
	
	@Override
	public List<Facture> getFactures() {
		
		return this.factureRepository.findAll();
	}

	@Override
	public Facture getFactureById(int id) {
	
		Optional<Facture> facture = this.factureRepository.findById(id);
		if (facture != null) {
			return facture.get();
		}
		return null;
	}

	@Override
	public void deleteFactureById(int id) {
		
		Optional<Facture> facture = this.factureRepository.findById(id);
		
		if (facture != null) {
			this.factureRepository.delete(facture.get());
			
		}
		
	}

	@Override
	public Facture saveFacture(Facture fact) {
		
		return this.factureRepository.save(fact);
	}

	@Override
	public Facture updateFacture(int id, Facture fact) {
	
		Optional<Facture> f = this.factureRepository.findById(id);
		if (f.isPresent() && id == fact.getId()) {
			return this.factureRepository.save(fact); }
		
		return null;
	}

}
