package com.group7.user.userdetails.service;

import org.springframework.stereotype.Service;

import com.group7.user.userdetails.dto.BuyerDTO;
import com.group7.user.userdetails.dto.SellerDTO;
@Service
public class Validator {

	public boolean validateBuyer(BuyerDTO buyerdto) {
		String name=buyerdto.getName();
		String email=buyerdto.getEmail();
		String phoneNo=buyerdto.getPhoneNumber();
		String password=buyerdto.getPassword();
		System.out.println(this.validateName(name)+" "+this.validateEmail(email)+this.validatePhone(phoneNo)+this.validatePassword(password));
		if(	this.validateName(name) && this.validateEmail(email) && this.validatePhone(phoneNo) && this.validatePassword(password))
			return true;
		else
			return false;
	}
	
	public boolean validateSeller(SellerDTO sellerdto) {
		String name=sellerdto.getName();
		String email=sellerdto.getEmail();
		String phoneNo=sellerdto.getPhoneNumber();
		String password=sellerdto.getPassword();
		System.out.println(this.validateName(name)+" "+this.validateEmail(email)+this.validatePhone(phoneNo)+this.validatePassword(password));	
		if(	this.validateName(name) && this.validateEmail(email) && this.validatePhone(phoneNo) && this.validatePassword(password))
			return true;
		else
			return false;
	}
	
	public boolean validateName(String name) {
		String regrex="^[A-Za-z ]+$";
		if(name.matches(regrex))
			return true;
		return false;
	}
	
	public boolean validateEmail(String email) {
		String regrex="^[A-Za-z]+[@]+[A-Za-z]+(.com)$";
		if(email.matches(regrex))
			return true;
		return false;
	}
	
	public boolean validatePhone(String phone) {
		String regrex="^[7-9]{1}[0-9]{9}$";
		if(phone.matches(regrex)) 
			return true;
		return false;
	}
	

	public boolean validatePhoneBuyer(String phone) {
		String regrex="^[7-9]{1}[0-9]{8}$";
		if(phone.matches(regrex)) 
			return true;
		return false;
	}
	
	public boolean validatePassword(String password) {
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=]).{7,20}$";
		if(password.matches(regex))
			return true;
		return false;
	}
}
