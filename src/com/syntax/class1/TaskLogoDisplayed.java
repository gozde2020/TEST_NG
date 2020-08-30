package com.syntax.class1;
//TC 1: HRMS Application Login: 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Open chrome browser
//Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//Enter valid username and password
//Click on login button
//Then verify Syntax Logo is displayed
//Close the browser


public class TaskLogoDisplayed {
	public static WebDriver driver;
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");;
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();

	}
	@Test
	public void verifyLogo() {
		
		boolean isLogoDisplayed = driver.findElement(By.cssSelector("img[alt='OrangeHRM']")).isDisplayed();
		if(isLogoDisplayed) {
			System.out.println("Logo is displayed "+isLogoDisplayed);
		}else {
			System.out.println("Logo is NOT displayed "+isLogoDisplayed);
		}
	
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
}	
