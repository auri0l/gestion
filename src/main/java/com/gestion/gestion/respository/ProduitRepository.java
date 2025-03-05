package com.gestion.gestion.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



import com.gestion.gestion.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}
