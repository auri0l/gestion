package com.gestion.gestion.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.gestion.entities.Invoice;




@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

}
