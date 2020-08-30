package com.syntax.class1;

import org.testng.annotations.Test;

public class TestNgIntro {
	
	@Test(priority = 1)
	public void testOne() {
		
		System.out.println("Test 1");
		
	}
	
	@Test(priority = 2)
	public void testTwo() {
		System.out.println(("Test 2"));
	}
	
	@Test(priority = 3)
	public void testThree() {
		System.out.println(("Test 3"));
	}
	
}
