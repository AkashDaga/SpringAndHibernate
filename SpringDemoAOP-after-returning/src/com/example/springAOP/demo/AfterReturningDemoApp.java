package com.example.springAOP.demo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springAOP.dao.AccountDao;
import com.example.springAOP.dao.MembershipDao;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				DemoConfig.class);

		AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
		
		List<Account> accountLists = accountDao.findAccounts();
		System.out.println("After Returning Demo App "+accountLists);
		
		applicationContext.close();

	}

}
