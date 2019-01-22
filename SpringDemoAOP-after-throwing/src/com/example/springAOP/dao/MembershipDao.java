package com.example.springAOP.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
	
	public void addAccount() {
		System.out.println(getClass()+" DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
	}
	
	public boolean addMember() {
		System.out.println(getClass()+" DOING STUFF: ADDING A MEMBER");
		
		return true;
	}
}
