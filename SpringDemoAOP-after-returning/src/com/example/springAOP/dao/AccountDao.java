package com.example.springAOP.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.springAOP.demo.Account;

@Component
public class AccountDao {
	
	public List<Account> findAccounts(){
		List<Account> accounts = new ArrayList<Account>();
		
		accounts.add(new Account("Binod","Platinum"));
		accounts.add(new Account("Pramod","Gold"));
		accounts.add(new Account("Akash","Silver"));
		accounts.add(new Account("Bikash","Bronze"));
		
		return accounts;
	}
	
	public void addAccount(Account account, boolean vip) {
		System.out.println(getClass()+" : DOING MY DB WORK: ADDING AN ACCOUNT "+account.toString()+"is a vip person "+ vip);
	}
	
	public void goToSleep() {
		System.out.println(getClass()+" : GOING TO SLEEP ");
	}
}
