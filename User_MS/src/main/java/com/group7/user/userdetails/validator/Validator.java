package com.group7.user.userdetails.validator;


import com.group7.user.userdetails.dto.BuyerDTO;
import com.group7.user.userdetails.dto.SellerDTO;

public class Validator {

	public static boolean validateBuyer(BuyerDTO buyerdto) throws Exception {
		String name=buyerdto.getName();
		String email=buyerdto.getEmail();
		String phoneNo=buyerdto.getPhoneNumber();
		String password=buyerdto.getPassword();
		if(validateName(name))
			throw new Exception("It can contain only alphabets and spaces. It should not start or end with a space. It can’t contain only spaces.");
		else if(validateEmail(email))
			throw new Exception("The email-id should be of the following format: example@exm.com");
		else if(validatePhone(phoneNo))
			throw new Exception("It should be a valid Indian mobile number. It can contain only digits and length should be 10.");
		else if(validatePassword(password))
			throw new Exception("It should be 7 to 20 characters in length (both inclusive). It should contain at least one uppercase, at least one lowercase, at least one digit. It should also contain a special character amongst -! @, #, $, %, ^, &, *");
		
		if(	validateName(name) && validateEmail(email) && validatePhone(phoneNo) && validatePassword(password))
			return true;
		else
			return false;
	}

	
	public static boolean validateSeller(SellerDTO sellerdto) throws Exception {
		String name=sellerdto.getName();
		String email=sellerdto.getEmail();
		String phoneNo=sellerdto.getPhoneNumber();
		String password=sellerdto.getPassword();
		if(validateName(name))
			throw new Exception("It can contain only alphabets and spaces. It should not start or end with a space. It can’t contain only spaces.");
		else if(validateEmail(email))
			throw new Exception("The email-id should be of the following format: example@exm.com");
		else if(validatePhone(phoneNo))
			throw new Exception("It should be a valid Indian mobile number. It can contain only digits and length should be 10.");
		else if(validatePassword(password))
			throw new Exception("It should be 7 to 20 characters in length (both inclusive). It should contain at least one uppercase, at least one lowercase, at least one digit. It should also contain a special character amongst -! @, #, $, %, ^, &, *");
		
		
		if(	validateName(name) && validateEmail(email) && validatePhone(phoneNo) && validatePassword(password))
			return true;
		else
			return false;
	}
	
	public static boolean validateName(String name) {
		String regrex="^[A-Za-z ]+$";
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
	

	public static boolean validatePhoneBuyer(String phone) {
		String regrex="^[7-9]{1}[0-9]{8}$";
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
