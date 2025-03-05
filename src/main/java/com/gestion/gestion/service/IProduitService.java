package com.gestion.gestion.service;

import java.util.List;

import com.gestion.gestion.entities.Produit;

public interface IProduitService {
	
	
	
	public List<Produit> getProduits(); 
	
	public Produit getProduitById(int id)  ;
	
	public void deleteProduitById(int id) ;
	
	public Produit saveProduit(Produit prod);
	
	public Produit updateProduit(int id, Produit prod) ;

}
