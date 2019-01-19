package com.example.springannotationsdemo;

import org.springframework.stereotype.Component;

@Component
public class RestfulFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "I will give you the interface for restful api calls";
	}

}
