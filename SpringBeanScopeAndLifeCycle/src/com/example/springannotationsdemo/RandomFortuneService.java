package com.example.springannotationsdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] data = {
			"Hell",
			"Friends",
			"Chai",
			"Peelo"
	};
	
	private Random myRandom = new Random();

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		int index = myRandom.nextInt(data.length);
		return data[index];
	}

}
