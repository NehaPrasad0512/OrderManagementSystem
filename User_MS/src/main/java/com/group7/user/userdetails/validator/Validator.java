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
		
		return (validateName(name) && validateEmail(email) && validatePhone(phoneNo) && validatePassword(password));
			
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
		
		
		return (validateName(name) && validateEmail(email) && validatePhone(phoneNo) && validatePassword(password));
		
	}
	
	public static boolean validateName(String name) {
		String regrex1="^[A-Za-z ]+$";
		return (name.matches(regrex1));
		
	}
	
	public static boolean validateEmail(String email) {
		String regrex2="^[A-Za-z]+[@]+[A-Za-z]+(.com)$";
		return (email.matches(regrex2));
	}
	
	public static boolean validatePhone(String phone) {
		String regrex3="^[7-9]{1}[0-9]{9}$";
		return (phone.matches(regrex3)); 
	}
	

	public static boolean validatePhoneBuyer(String phone) {
		String regrex4="^[7-9]{1}[0-9]{8}$";
		return (phone.matches(regrex4));
	}
	
	public static boolean validatePassword(String password) {
		String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=]).{7,20}$";
		return (password.matches(regex));
	}
}
