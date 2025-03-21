package com.app.finanace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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
	private	CibilService cibilService;

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
	public ResponseEntity<Enquiry> updateCibilScore(@PathVariable("customerID") int customerID) {

		Enquiry enquiry = enquiryService.updateCibilScore(customerID);
		return new ResponseEntity<Enquiry>(enquiry, HttpStatus.OK);
	
	}
	@PatchMapping("/updateByFirstname/{customerID}")
	public ResponseEntity<Enquiry> onUpdateEnquiryFirstName(@RequestBody Enquiry e,@PathVariable("customerID")int customerID){
		Enquiry enquiry = enquiryService.updateFirstName(e.getFirstName(), customerID);
		
		enquiryService.saveEnquiry(enquiry);
		return new ResponseEntity<Enquiry>(enquiry,HttpStatus.OK);
	}
	@PatchMapping("/updateByLastname/{customerID}")
	public ResponseEntity<Enquiry> onUpdateEnquiryLastName(@RequestBody Enquiry e,@PathVariable("customerID")int customerID){
		Enquiry lastName = enquiryService.updateLastName(e.getLastName(), customerID);
		enquiryService.saveEnquiry(lastName);
		return new ResponseEntity<Enquiry>(lastName,HttpStatus.OK);
	}
	@PatchMapping("/updateByEmailId/{customerID}")
	public ResponseEntity<Enquiry> onUpdateEnquiryEmail(@RequestBody Enquiry e,@PathVariable("customerID")int customerID){
		Enquiry updateEmail = enquiryService.updateEmail(e.getEmail(), customerID);
		enquiryService.saveEnquiry(updateEmail);
		return new ResponseEntity<Enquiry>(updateEmail,HttpStatus.OK);
	}
	@PatchMapping("/updateByMobileno/{customerID}")
	public ResponseEntity<Enquiry> onUpdateEnquiryMobileno(@RequestBody Enquiry e,@PathVariable("customerID")int customerID){
		Enquiry updateMobileNo = enquiryService.updateMobileNo(e.getMobileNo(), customerID);
		enquiryService.saveEnquiry(updateMobileNo);
		return new ResponseEntity<Enquiry>(updateMobileNo,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
}
