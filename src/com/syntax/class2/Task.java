package com.syntax.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task {
public static WebDriver driver;
	//: HRMS Add Employee: 

//Open chrome browser
//Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
//Login into the application
//Click on Add Employee
//Verify labels: Full Name, Employee Id, Photograph are displayed
//Provide Employee First and Last Name
//Add a picture to the profile
//Verify Employee has been added successfully
//Close the browser




	@BeforeMethod
	public void openBrowser()  {
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
	public void verifyLabels() throws InterruptedException {
		
		//login +clicik PIM+ click add employee
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");;
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("PIM")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		
		Thread.sleep(2000);
		
		
		
		
		WebElement firstname=driver.findElement(By.xpath("(//div[@class = 'fieldDescription'])[1]"));
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(firstname.isDisplayed());
	

		
		WebElement empId=driver.findElement(By.xpath("//label[text() = 'Employee Id']"));
		softAssertion.assertTrue(empId.isDisplayed());
		
		
		WebElement photo=driver.findElement(By.xpath("//label[text() = 'Photograph']"));
		softAssertion.assertTrue(photo.isDisplayed());
	
		
		Thread.sleep(2000);
		

		WebElement empname = driver.findElement(By.id("firstName"));
		empname.sendKeys("aaaa");
		
		WebElement emplastname = driver.findElement(By.id("lastName"));
		emplastname.sendKeys("bcbc");
		
		
		WebElement chooseFile = driver.findElement(By.id(("photofile")));
		chooseFile.sendKeys("/Users/gozde.ercevik/Desktop/pictureTest.png");
		Thread.sleep(2000);
		
		
		WebElement save = driver.findElement(By.id("btnSave"));
		save.click();
		
		String expectedEmpName = "aaaa bcbc";
		WebElement name=driver.findElement(By.xpath("//div[@id = 'profile-pic']/h1"));
		softAssertion.assertEquals(name.getText(),expectedEmpName);
		
		
		
	}
	
	
}	
	

	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

