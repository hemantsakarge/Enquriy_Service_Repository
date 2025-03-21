package com.app.finanace.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.finanace.model.Enquiry;
import com.app.finanace.model.Enums;
import com.app.finanace.repository.EnquiryRepository;
import com.app.finanace.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	EnquiryRepository enquiryRepository;

	@Autowired
	JavaMailSender sender;

	@Override
	public void saveEnquiry(Enquiry e) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom("hemantsakarge@gmail.com");
		mail.setTo(e.getEmail());
		mail.setText("welcome to cjc");
		mail.setSubject("about enquiry");

		enquiryRepository.save(e);
		sender.send(mail);
	}

	@Override
	public Enquiry findByCustomerID(int customerID) {

		Enquiry enquiry = enquiryRepository.findByCustomerID(customerID);
		return enquiry;
	}

	@Override
	public List<Enquiry> findALL() {

		return (List<Enquiry>) enquiryRepository.findAll();
	}

	@Override
	public Enquiry updateCibilScore(int customerID) {

		Enquiry enquiry = enquiryRepository.findByCustomerID(customerID);

		int cibilCheck = CibilServiceImpl.checkCibilScore();
		enquiry.getCibil().setCibilScore(cibilCheck);

		if (cibilCheck >= 700)
			enquiry.getCibil().setCibilStatus(Enums.accept);
		else
			enquiry.getCibil().setCibilStatus(Enums.reject);

			enquiry.getCibil().setCibilScore(cibilCheck);

		enquiryRepository.save(enquiry);
		return enquiry;

	}

	@Override
	public Enquiry updateFirstName(String firstName, int customerID) {
		enquiryRepository.updateFirstName(firstName, customerID);
		Enquiry enquiry=enquiryRepository.findByCustomerID(customerID);
		return enquiry;
		
	}

	@Override
	public Enquiry updateLastName(String lastName, int customerID) {
		enquiryRepository.updateLastName(lastName, customerID);
		Enquiry enquiry=enquiryRepository.findByCustomerID(customerID);
		return enquiry;
	}

	@Override
	public Enquiry updateEmail(String email, int customerID) {
		enquiryRepository.updateEmail(email, customerID);
		Enquiry enquiry=enquiryRepository.findByCustomerID(customerID);
		return enquiry;
	}

	@Override
	public Enquiry updateMobileNo(long mobileNo, int customerID) {
		enquiryRepository.updateMobileNo(mobileNo, customerID);
		Enquiry enquiry=enquiryRepository.findByCustomerID(customerID);
		return enquiry;
	}

	

	

}
