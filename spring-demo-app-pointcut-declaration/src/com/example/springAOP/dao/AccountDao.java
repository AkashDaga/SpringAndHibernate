package com.example.springAOP.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
	
	private String name;
	private String serviceCode;
	
	public String getName() {
		System.out.println(getClass()+" : getName method");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+" : setName method");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+" : getServiceCode method");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+" : setServiceCode method");
		this.serviceCode = serviceCode;
	}

	public void addAccount(Account account, boolean vip) {
		System.out.println(getClass()+" : DOING MY DB WORK: ADDING AN ACCOUNT "+account.toString()+"is a vip person "+ vip);
	}
	
	public void goToSleep() {
		System.out.println(getClass()+" : GOING TO SLEEP ");
	}
}
