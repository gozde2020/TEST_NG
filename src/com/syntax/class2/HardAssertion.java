package com.syntax.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertion {
	
public static WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();

	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void titleValidation() {
		String expectedTitle = "Human Management SystemS"; // "Human Management System"-->RIGHT ONE
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle,expectedTitle);
	}
		
//		if(actualTitle.equals(expectedTitle)) {
//			System.out.println("Title are match. Test passed "+actualTitle);
//		}else {
//			System.out.println("Titles dont match. Test failed");
//		}
		
		@Test 
		public void logoValidation() {
			WebElement element = driver.findElement(By.xpath("//img[starts-with(@src, '/hu')]")); ////div[@id='divLogo']/img  ,  ////img[contains(text(), ‘/hu')]
			Assert.assertTrue(element.isDisplayed());
		}
		
		@Test
		public void loginFormText() {
			String expectedText = "LOGIN Panels";// "LOGIN Panel" -->RIGHT ONE
			WebElement loginForm=driver.findElement(By.id("loginPanelHeading"));
			Assert.assertEquals(loginForm.getText(), expectedText, "Text on the login is not matched");
		}
}