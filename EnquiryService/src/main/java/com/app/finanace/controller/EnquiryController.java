package com.app.finanace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.finanace.model.Cibil;
import com.app.finanace.model.Enquiry;
import com.app.finanace.model.Enums;
import com.app.finanace.service.CibilService;
import com.app.finanace.service.EnquiryService;
import com.app.finanace.serviceimpl.CibilServiceImpl;

@RestController
public class EnquiryController {

	@Autowired
	private EnquiryService enquiryService;
	@Autowired
	CibilService cibilService;

	@PostMapping("/saveenquiry")
	public ResponseEntity<Enquiry> onEnqury(@RequestBody Enquiry e) {
		enquiryService.saveEnquiry(e);

		return new ResponseEntity<Enquiry>(e, HttpStatus.CREATED);

	}

	@GetMapping("/getenquirybyenquiryId/{customerID}")
	public ResponseEntity<Enquiry> onGeEnquiry(@PathVariable("customerID") int customerID) {
		Enquiry enquiry = enquiryService.findByCustomerID(customerID);
		return new ResponseEntity<Enquiry>(enquiry, HttpStatus.OK);

	}

	@GetMapping("/getAllEnquiry")
	public ResponseEntity<List<Enquiry>> onGetAllEnquiry() {
		List<Enquiry> allEnquiries = enquiryService.findALL();

		return new ResponseEntity<List<Enquiry>>(allEnquiries, HttpStatus.OK);

	}

	@PutMapping("/updateCibilScore/{customerID}")
	public ResponseEntity<Enquiry> updateCibilScoreby(@PathVariable("customerID") int customerID) {

		Enquiry enquiry = enquiryService.updateCibilScore(customerID);


		return new ResponseEntity<Enquiry>(enquiry, HttpStatus.OK);
	}

	
	
	
}
