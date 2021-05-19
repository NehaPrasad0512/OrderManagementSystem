package com.group7.user.userdetails.validator;

import com.group7.user.userdetails.dto.BuyerDTO;
import com.group7.user.userdetails.dto.SellerDTO;

public class Validator {

	public static boolean validateBuyer(BuyerDTO buyerdto) {
		String name=buyerdto.getName();
		String email=buyerdto.getEmail();
		String phoneNo=buyerdto.getPhoneNumber();
		String password=buyerdto.getPassword();
		
		if(	validateName(name) && validateEmail(email) && validatePhone(phoneNo) && validatePassword(password))
			return true;
		else
			return false;
	}
	
	public boolean validateSeller(SellerDTO sellerdto) {
		String name=sellerdto.getName();
		String email=sellerdto.getEmail();
		String phoneNo=sellerdto.getPassword();
		String password=sellerdto.getPassword();
		
		if(validateName(name) && validateEmail(email) && validatePhone(phoneNo) && validatePassword(password))
			return true;
		else
			return false;
	}
	
	public static boolean validateName(String name) {
		String regrex="^([A-Za-z]+([ ][A-Za-z]+)*)$";
		if(name.matches(regrex))
			return true;
		return false;
	}
	
	public static boolean validateEmail(String email) {
		String regrex="^[A-Za-z]+[@]+[A-Za-z]+(.com)$";
		if(email.matches(regrex))
			return true;
		return false;
	}
	
	public static boolean validatePhone(String phone) {
		String regrex="^[7-9]{1}[0-9]{9}$";
		if(phone.matches(regrex)) 
			return true;
		return false;
	}
	
	public static boolean validatePassword(String password) {
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=]).{7,20}$";
		if(password.matches(regex))
			return true;
		return false;
	}
}
