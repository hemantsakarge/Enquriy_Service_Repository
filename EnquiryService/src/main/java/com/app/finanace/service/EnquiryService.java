package com.app.finanace.service;

import java.util.List;

import com.app.finanace.model.Enquiry;

public interface EnquiryService {

public 	void saveEnquiry(Enquiry e);

public Enquiry findByCustomerID(int customerID);

public List<Enquiry> findALL();

public Enquiry updateCibilScore(int customerID);

public Enquiry updateFirstName(String firstName,int customerID);

public Enquiry updateLastName(String lastName,int customerID);

public Enquiry updateEmail(String email,int customerID);

public Enquiry updateMobileNo(long mobileNo,int customerID);


}
