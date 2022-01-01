package com.juaracoding.ujian6.utils;

public enum TestCases {

	T1("Testing Account Register"),
	T2("Testing Login Account"),
	T3("Testing Add to Cart Shoes"),
	T4("Testing Add to Cart Glass"),
	T5("Testing Checkout");
	
	private String testName;	

	TestCases(String value){
		this.testName = value;
	}
	
	public String getTestName() {
		return testName;
	}
}
