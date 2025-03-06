package com.gestion.gestion.service;

import java.util.List;

import com.gestion.gestion.entities.Facture;



public interface IFactureService {
	
	public List<Facture> getFactures(); 
	
	public Facture getFactureById(int id)  ;
	
	public void deleteFactureById(int id) ;
	
	public Facture saveFacture(Facture fact);
	
	public Facture updateFacture(int id, Facture fact) ;


}
