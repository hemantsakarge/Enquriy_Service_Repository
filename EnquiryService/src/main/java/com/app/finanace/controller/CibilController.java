package com.app.finanace.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.finanace.model.Cibil;
import com.app.finanace.service.CibilService;
import com.app.finanace.service.EnquiryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CibilController {

	@Autowired
	private CibilService cibilService;
	
	@Autowired
	private EnquiryService enquiryService;
	
	
	@PatchMapping("/updatecibilbyid/{enquiryId}")
	public ResponseEntity<Cibil>onUpdate(@PathVariable("enquiryId")int enquiryId)
	{
			
		
		return null;
	}
	
	@GetMapping("/getcibilid/{cibilId}")
	public ResponseEntity<Cibil> findByCibilId(@PathVariable("cibilId") int cibilId){
		
		Cibil cibil=cibilService.findByCibilId(cibilId);
		
		return new ResponseEntity<Cibil>(cibil,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/save")
	public ResponseEntity<Cibil> onEnroll(@RequestBody Cibil cibil) {

		cibilService.saveCibil(cibil);

		return new ResponseEntity<Cibil>(cibil, org.springframework.http.HttpStatus.CREATED);
	}
	
}
