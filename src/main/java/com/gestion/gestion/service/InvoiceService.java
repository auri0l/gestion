package com.gestion.gestion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gestion.gestion.entities.Invoice;
import com.gestion.gestion.respository.InvoiceRepository;

@Service
public class InvoiceService implements IInvoiceService {

	private InvoiceRepository invoiceRepository;
	
	@Override
	public List<Invoice> getInvoices() {
		
		return this.invoiceRepository.findAll();
	}

	@Override
	public Invoice getInvoiceById(int id) {
	
		Optional<Invoice> invoice = this.invoiceRepository.findById(id);
		if (invoice != null) {
			return invoice.get();
		}
		return null;
	}

	@Override
	public void deleteInvoiceById(int id) {
		
		Optional<Invoice> invoice = this.invoiceRepository.findById(id);
		
		if (invoice != null) {
			this.invoiceRepository.delete(invoice.get());
			
		}
		
	}

	@Override
	public Invoice saveInvoice(Invoice invc) {
		
		return this.invoiceRepository.save(invc);
	}

	@Override
	public Invoice updateInvoice(int id, Invoice invc) {
	
		Optional<Invoice> f = this.invoiceRepository.findById(id);
		if (f.isPresent() && id == invc.getId()) {
			return this.invoiceRepository.save(invc); }
		
		return null;
	}

}
