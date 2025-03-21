package com.app.finanace.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.finanace.exceptions.EnquiryObjectNotFoundException;
import com.app.finanace.model.Enquiry;
import com.app.finanace.model.Enums;
import com.app.finanace.repository.EnquiryRepository;
import com.app.finanace.service.EnquiryService;

@Service
public class EnquiryServiceImpl implements EnquiryService {

	@Autowired
	EnquiryRepository enquiryRepository;

	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	@Autowired
	JavaMailSender sender;

	@Override
	public void saveEnquiry(Enquiry e) {
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setFrom(fromMail);
		mail.setTo(e.getEmail());
		
	String text =
	             "Dear"+ e.getFirstName() +" "+e.getLastName()+"\n\n"
	            + "Thank you for reaching out to us. We’ve received your inquiry and our team is currently reviewing it. "
	            + "We will get back to you as soon as possible with more details or a solution to your request.\n\n"
	            + "If you have any additional information or questions, feel free to reply to this email or contact us directly at "
	           
	            + "We appreciate your interest in our services/products and look forward to assisting you!\n\n"
	            + "Best regards,\n"
	            + fromMail;
		
		mail.setText(text);
		mail.setSubject(" Thank You for Your Inquiry – ");

		enquiryRepository.save(e);
		sender.send(mail);
	}

	@Override
	public Enquiry findByCustomerID(int customerID) {

		Enquiry enquiry = enquiryRepository.findByCustomerID(customerID);
		if(enquiry==null) {
			throw new EnquiryObjectNotFoundException("The Enquiry for "+customerID+ " Not Found");
		}
		else
		{
			return enquiry;	
		}
		
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

		if (cibilCheck >= 600)
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
		
		if(enquiry==null) {
			throw new EnquiryObjectNotFoundException("The Enquiry for "+customerID+"Not Found");
		}
		else
		{
			return enquiry;	
		}
	}

	@Override
	public Enquiry updateLastName(String lastName, int customerID) {
		enquiryRepository.updateLastName(lastName, customerID);
		Enquiry enquiry=enquiryRepository.findByCustomerID(customerID);
		if(enquiry==null) {
			throw new EnquiryObjectNotFoundException("The Enquiry for "+customerID+"Not Found");
		}
		else
		{
			return enquiry;	
		}
	}

	@Override
	public Enquiry updateEmail(String email, int customerID) {
		enquiryRepository.updateEmail(email, customerID);
		Enquiry enquiry=enquiryRepository.findByCustomerID(customerID);
		
		if(enquiry==null) {
			throw new EnquiryObjectNotFoundException("The Enquiry for "+customerID+"Not Found");
		}
		else
		{
			return enquiry;	
		}
	}

	@Override
	public Enquiry updateMobileNo(long mobileNo, int customerID) {
		enquiryRepository.updateMobileNo(mobileNo, customerID);
		Enquiry enquiry=enquiryRepository.findByCustomerID(customerID);
		if(enquiry==null) {
			throw new EnquiryObjectNotFoundException("The Enquiry for "+customerID+"Not Found");
		}
		else
		{
			return enquiry;	
		}
	}

	

	

}
