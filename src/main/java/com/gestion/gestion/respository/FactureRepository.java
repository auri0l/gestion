package com.gestion.gestion.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestion.entities.Facture;




@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer> {

}
