package com.example.springAOP.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.springAOP.dao.AccountDao;
import com.example.springAOP.dao.MembershipDao;

public class MainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				DemoConfig.class);

		AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
		Account account = new Account();
		account.setLevel("Begginer");
		account.setName("Akash");
		accountDao.addAccount(account, true);
		accountDao.goToSleep();

		MembershipDao membershipDao = applicationContext.getBean("membershipDao", MembershipDao.class);
		membershipDao.addAccount();
		membershipDao.addMember();

		applicationContext.close();

	}

}
