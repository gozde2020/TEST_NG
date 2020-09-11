package com.syntax.class3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class HW {
/*TC 1: HRMS Add Employee: 

Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Login into the application
Add 5 different Employees and create login credentials by providing: 
First Name
Last Name
Username
Password
Verify Employee has been added successfully and take screenshot (you must have 5 different screenshots)
Close the browser
Specify group for this test case, add it into specific suite and execute from xml file.
*/
	public static WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@AfterMethod(alwaysRun = true)
	public void closeBrowser() {
		driver.quit();
	}

	@Test (dataProvider = "getData", groups="smoke")
	public void multipleLogin(String username, String password, String name, String screenshot) throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		Thread.sleep(2000);
		String welcomeText = driver.findElement(By.id("welcome")).getText();
		
		Assert.assertEquals(welcomeText,"Welcome "+name);
		
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File("screens/HRMS/"+screenshot+".png"));
		} catch (IOException e) {  
			
			e.printStackTrace();
		}
		
	}
	
	@DataProvider
	
	public Object[][]  getData(){
		Object [] [] data = {
				{"TurkanS", "Yesilcam!001","Turkan","TC1"},
				{"FilizA", "Yesilcam@002","Filiz","TC2"},
				{"GulseB", "Yesilcam#003","Gulse","TC3"},
				{"Janet","Losangeles*002","Janet","TC4"},
				{"La Toya","Losangeles&003","La Toya","TC5"},
				};
		
		return data;
	}
	
	
}
