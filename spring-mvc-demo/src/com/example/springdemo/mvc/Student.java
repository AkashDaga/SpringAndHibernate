package com.example.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String favouriteLanguage;
	private String[] operatingSystems;
	private LinkedHashMap<String, String> countryOptions;
	private LinkedHashMap<String, String> favouriteLanguageOptions;
	private LinkedHashMap<String, String> favouriteOperatingSystemOptions;

	public Student() {
		countryOptions = new LinkedHashMap<>();

		countryOptions.put("IND", "INDIA");
		countryOptions.put("BR", "BRAZIL");
		countryOptions.put("FR", "FRANCE");
		countryOptions.put("GE", "GERMANY");
		countryOptions.put("US", "United State of America");

		favouriteLanguageOptions = new LinkedHashMap<>();

		favouriteLanguageOptions.put("JAVA", "JAVA");
		favouriteLanguageOptions.put("C", "C");
		favouriteLanguageOptions.put("C++", "C++");
		favouriteLanguageOptions.put("PHP", "PHP");
		favouriteLanguageOptions.put("JS", "JAVA SCRIPT");
		
		favouriteOperatingSystemOptions = new LinkedHashMap<>();

		favouriteOperatingSystemOptions.put("WINDOWS", "WINDOWS");
		favouriteOperatingSystemOptions.put("LINUX", "LINUX");
		favouriteOperatingSystemOptions.put("UBUNTU", "UBUNTU");
		favouriteOperatingSystemOptions.put("MAC", "MAC");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public LinkedHashMap<String, String> getFavouriteLanguageOptions() {
		return favouriteLanguageOptions;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public LinkedHashMap<String, String> getFavouriteOperatingSystemOptions() {
		return favouriteOperatingSystemOptions;
	}
	
	

}
