package com.syntax.class3;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HW2ndversion {
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
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://166.62.36.207/humanresources/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
	
	}
	
	@AfterMethod(alwaysRun =true)
	
	public void quitBrowser() {
		driver.quit();
	}

	
	@Test(dataProvider="allData", groups = "Regression")
	public void addEmployee(String name, String lastname, String username, String password,String screenshot) throws InterruptedException {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.id("btnLogin")).click();
		
	
		driver.findElement(By.id("menu_pim_viewPimModule")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("menu_pim_addEmployee")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("firstName")).sendKeys(name);
		driver.findElement(By.id("lastName")).sendKeys(lastname);
		driver.findElement(By.id("chkLogin")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("user_name")).sendKeys(username);
		driver.findElement(By.id("user_password")).sendKeys(password);
		driver.findElement(By.id("re_password")).sendKeys(password);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(3000);
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		File path = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(path,  new File("screens/HRMS/"+screenshot+".png"));
		}
		catch(IOException e){
				e.printStackTrace();
			}
		
		
		WebElement fullName = driver.findElement(By.xpath("//div[@id = 'profile-pic']/h1"));
		String expected = name + " " + lastname;
		Assert.assertEquals(fullName.getText(),expected);
}
		@DataProvider
		
		public String [][] allData (){
			
			String [][] data={
			{"Cenan", "Kenan", "CenanK","Cenankenan!1","Cenan"},
			{"Berken","Olcay","BerkenO","Berkenolcay@2","Berken"},
			{"Halem","Taylan","HalemT","Haletaylan#3","Halem"}
			};
		
		return data;
		
				
		}
	
	
}
