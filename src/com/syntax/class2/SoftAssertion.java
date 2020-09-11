package com.syntax.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
public static WebDriver driver;
	
	@BeforeMethod(alwaysRun=true)
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();

	}
	
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}
	
	
	@Test
	public void invalidLoginError() throws InterruptedException {
		
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");;
		driver.findElement(By.id("txtPassword")).sendKeys("Humm");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		
		SoftAssert softAssertion = new SoftAssert();
		String expectedErrordMsg = "Invalid credential";//dogrusu Invalid credentials// bilerek yanlis yaziyoruz
		
		WebElement errorMsg =driver.findElement(By.id("spanMessage"));
		//first validation
		
		softAssertion.assertEquals(errorMsg.getText(),expectedErrordMsg);
		
		Thread.sleep(2000);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");;
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		
		String errorMsg2 = "Password cannot be";//real is Password cannot be empty
		errorMsg = driver.findElement(By.id("spanMessage"));
		
		//2 validation
		softAssertion.assertEquals(errorMsg.getText(),errorMsg2 );
		Thread.sleep(3000);
		
		System.out.println("i am text after the asseetion");
		System.out.println("--------- this is the end of the test-------");
		
		softAssertion.assertAll();
		
				
		
	}
}
