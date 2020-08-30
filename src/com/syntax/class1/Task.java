package com.syntax.class1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Create class that will have:
//Before and After Class annotation
//Before and After Method annotation
//2 methods with Test annotation
public class Task {
	
	
	@BeforeMethod
	public void before() {
		
		System.out.println("This is before method");
	}

	
	@Test 
	public void testMethod1() {
		System.out.println("I am the first test");
	}
	
	@Test 
	public void testMethod2() {
		System.out.println("I am the second test");
	}

	
	@AfterMethod 
	public void aftermethod() {
		System.out.println("This is after method");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("This is before class method");
		
	}
	
	
	@AfterClass
	public void afterClass() {
		
		System.out.println("This is after class method");
	}
	
	
}
