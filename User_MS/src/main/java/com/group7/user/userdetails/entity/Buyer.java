package com.group7.user.userdetails.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Buyer {
	@Id
	private String buyerId;
	private String name;
	private String email;
	private String phoneNumber;
	private String password;
	private String isPiviledged;
	private int rewardPoints;
	private String isActive;
	
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIsPiviledged() {
		return isPiviledged;
	}
	public void setIsPiviledged(String isPiviledged) {
		this.isPiviledged = isPiviledged;
	}
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
