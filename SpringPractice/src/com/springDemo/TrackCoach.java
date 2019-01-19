package com.springDemo;

public class TrackCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public TrackCoach() {
		
	}
	
	public TrackCoach(FortuneService fortuneService) {
		// TODO Auto-generated constructor stub
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "run hard at 5k";
	}
	
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Just Do it: "+fortuneService.getFortune();
	}
	
	public void doMyStartupStuff() {
		System.out.println("doMyStartupStuff is fired");
	}
	
	public void doMyCleanupStuff() {
		System.out.println("doMyCleanupStuff is fired");
	}
}
