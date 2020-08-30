package com.syntax.class2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllAnnotations {
	
	@BeforeSuite
	public void beforeSuit() {
		System.out.println("This is before suit test method");
	}
	
	@BeforeTest
		public void beforeTest() {
		System.out.println("This is before test method");
	}
	
	
	
	@BeforeMethod
	public void beforeMethod() {
		
		System.out.println("This is beforemethod test method");
	}


	@Test
	public void testMethod() {
		
		System.out.println("This is actual test method");
	}
	
	@Test
	public void testMethod2() {
		
		System.out.println("This is actual test method2");
	}
	
	@Test
	public void testMethod3() {
		
		System.out.println("This is actual test method3");
	}
	
	@AfterMethod
	public void after() {
		System.out.println("This is after test method");
	}
	
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("------This is before class annotation----");
	}
	
	
	@AfterClass
	public void afterClass() {
		System.out.println("-----This is after class annotation------");
		
	}
	
	
	@AfterTest
	public void afterTest() {
		System.out.println("-----This is after class annotation------");
		
	}
	@AfterSuite
	public void afterSuit() {
		System.out.println("-----This is after suit annotation------");
	}
	

}
