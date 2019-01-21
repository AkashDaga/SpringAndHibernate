package com.example.springAOP.dao;

import org.springframework.stereotype.Component;

import com.example.springAOP.demo.Account;

@Component
public class AccountDao {
	public void addAccount(Account account, boolean vip) {
		System.out.println(getClass()+" : DOING MY DB WORK: ADDING AN ACCOUNT "+account.toString()+"is a vip person "+ vip);
	}
	
	public void goToSleep() {
		System.out.println(getClass()+" : GOING TO SLEEP ");
	}
}
