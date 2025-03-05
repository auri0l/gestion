package com.gestion.gestion.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.gestion.gestion.entities.Produit;
import com.gestion.gestion.respository.ProduitRepository;



@Service
public class ProduitService implements IProduitService {
	
	
	private ProduitRepository produitRepository;
	

	@Override
	public List<Produit> getProduits() {
		
		return this.produitRepository.findAll();
	}
	

	@Override
	public Produit getProduitById(int id) {
		Optional<Produit> produit = this.produitRepository.findById(id);
		if (produit != null) {
			return produit.get();
		}
		return null;
	}

	@Override
	public void deleteProduitById(int id) {

		Optional<Produit> produit = this.produitRepository.findById(id);
		if (produit != null) {
			this.produitRepository.delete(produit.get());
		}	
		
	}
	

	@Override
	public Produit saveProduit(Produit prod) {
		return this.produitRepository.save(prod);
	}
	

	@Override
	public Produit updateProduit(int id, Produit prod) {
		

		Optional<Produit> p = this.produitRepository.findById(id);
		if (p.isPresent() && id == prod.getId()) {
			return this.produitRepository.save(prod); }
		
		return null;
	}

}
