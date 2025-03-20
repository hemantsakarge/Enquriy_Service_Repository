package com.app.finanace.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.finanace.model.Enquiry;

@Repository
public interface EnquiryRepository extends CrudRepository<Enquiry, Integer> {


public Enquiry findByCustomerID(int customerID);
	
	
}
