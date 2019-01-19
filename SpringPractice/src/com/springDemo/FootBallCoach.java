package com.springDemo;

public class FootBallCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public FootBallCoach(FortuneService fortuneService) {
		// TODO Auto-generated constructor stub
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Do 15 mins of Dribblling";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "La Liga : "+fortuneService.getFortune();
	}

}
