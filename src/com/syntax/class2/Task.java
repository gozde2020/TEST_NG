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
	public void openBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");;
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input#btnLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("PIM"));
		driver.findElement(By.id("menu_pim_addEmployee"));
		
		WebElement empname = driver.findElement(By.id("firstName"));
		empname.sendKeys("hello");
		WebElement emplastname = driver.findElement(By.id("lastName"));
		emplastname.sendKeys("humans");
		WebElement save = driver.findElement(By.id("btnSave"));
		save.click();
	
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void verifyLabels() {
		
		
		String expectedTitle1 = "Full Name"; 
		WebElement firstname=driver.findElement(By.xpath("//label[@class='hasTopFieldHelp']"));
		
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(firstname.getText(),expectedTitle1);
	

		String expectedTitle2 = "Employee Id"; 
		WebElement empId=driver.findElement(By.xpath("//label[@for='employeeId']"));
		
		
		softAssertion.assertEquals(empId.getText(),expectedTitle2);
		
		
		String expectedTitle3 = "Photograph"; 
		WebElement photo=driver.findElement(By.xpath("//label[@for='photofile']"));
		
		
		softAssertion.assertEquals(photo.getText(),expectedTitle3);
		
		

		String expectedEmpName = "hello humans";
		WebElement name=driver.findElement(By.xpath("//div[@id = 'profile-pic']/h1"));
		softAssertion.assertEquals(name.getText(),expectedEmpName);
	}
	
	
}	
	
//	@Test
//	public void uploadPhoto() {
//		WebElement fileUpload = driver.findElement(By.xpath("//input[@class = 'duplexBox']"));
//		fileUpload.click(); 
//		
//		WebElement chooseFile = driver.findElement(By.id(("file-upload")));
//		chooseFile.sendKeys("/Users/gozde.ercevik/Desktop/TestSeleniumUpload.xlsx");
//		
//		WebElement upload = driver.findElement(By.id("file-submit"));
//		upload.click();
//	}
//	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

