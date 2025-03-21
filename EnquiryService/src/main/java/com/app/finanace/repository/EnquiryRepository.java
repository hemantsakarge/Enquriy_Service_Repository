package com.app.finanace.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.finanace.model.Enquiry;

import jakarta.transaction.Transactional;

@Repository
public interface EnquiryRepository extends CrudRepository<Enquiry, Integer> {


public Enquiry findByCustomerID(int customerID);
	
@Transactional
@Modifying
@Query(value = "update Enquiry set firstName=:fn where customerID=:id")
public void updateFirstName(@Param("fn")String firstName,@Param("id") int customerID);

@Transactional
@Modifying
@Query(value = "update Enquiry set lastName=:nm where customerID=:id")
public void updateLastName(@Param("nm")String lastName,@Param("id")int customerID);

@Transactional
@Modifying
@Query(value = "update Enquiry set email=:em where customerID=:id")
public void updateEmail(@Param("em")String email,@Param("id")int customerID);

@Transactional
@Modifying
@Query(value = "update Enquiry set mobileNo=:mn where customerID=:id")
public void updateMobileNo(@Param("mn")long mobileNo,@Param("id")int customerID);




















}
