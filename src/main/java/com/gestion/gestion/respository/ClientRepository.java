package com.gestion.gestion.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestion.entities.Client;



@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

}
