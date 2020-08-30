package com.syntax.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Dependancy {
	
public static WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		
	}
	
	
	@Test
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");;
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	
		String welcomeText = driver.findElement(By.id("welcome")).getText();
		if(welcomeText.contains("Admin")) {
			System.out.println("Admin is logged in. Test passed");
		}else {
			System.out.println("Admin is NOT logged in.Test Failed");
			
		}
		
	}
	
	
	@Test(dependsOnMethods = "validLogin")
	public void invalidLogin() {
		
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");;
		driver.findElement(By.id("txtPassword"));
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		WebElement msg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
		
		String expectedMsg = "Password cannot be empty";
		String actualMsg =msg.getText();
		if(actualMsg.equals(expectedMsg)) {
			System.out.println("-Password cannot be empty- is displayed. TEST PASS");
		}else {
			System.out.println("-Password cannot be empty- is NOT displayed. TEST FAIL");
		}
		
				
		
	}
	@Test
	public void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Title are match. Test passed "+actualTitle);
		}else {
			System.out.println("Titles dont match. Test failed");
		}
		
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
