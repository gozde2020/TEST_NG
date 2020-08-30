package com.syntax.class1;
//Open chrome browser
//Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//Enter valid username
//Leave password field empty
//Verify error message with text “Password cannot be empty” is displayed

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskNegativeLogin {
	public static WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	
	@Test
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
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	
	
	
	
	
}
