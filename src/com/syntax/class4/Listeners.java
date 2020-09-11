package com.syntax.class4;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener{
	//invoke when we start every @Test method
	public void onTestStart(ITestResult result) {
		
		System.out.println("Test started "+result.getName());
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test passed "+result.getName());
		
		System.out.println("Here will code that takes screenshot for any pased test cases");
	}
	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed "+result.getName());
		System.out.println("Here will code that takes screenshot for any failed test cases");
	}
	//invoke when we start <test based on xml file
	public void onStart(ITestContext context) {
		System.out.println("Starting test inside xml "+context.getName());
		
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("Ending test inside xml "+context.getName());
		
	}
}
