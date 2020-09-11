package com.syntax.class3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestforTalai {
	
	@Test
	
	public void iframe() {
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.get("http://www.uitestpractice.com/Students/Index");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement controls = driver.findElement(By.linkText("Controls"));
		controls.click();

		WebElement iframe = driver.findElement(By.xpath("//iframe[@name='iframe_a']"));
		driver.switchTo().frame(iframe);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.getElementById('name').setAttribute('TestName', '10')");
		driver.findElement(By.id("name")).sendKeys("testssss",Keys.ENTER);
		//driver.findElement(By.id("name")).sendKeys("TestName");
		//
		String expectedIframeText = "TestName";
//		WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.textToBePresentInElement(
//				driver.findElement(By.xpath("//label[contains(text(),'Enter your name')]/following-sibling::input")),
//				"TestName"));
		String actualIframeText = driver
				.findElement(By.xpath("//label[contains(text(),'Enter your name')]/following-sibling::input"))
				.getText();
		System.out.println("gkjgkjhkjh"+actualIframeText);
		driver.switchTo().defaultContent();
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(actualIframeText, expectedIframeText);
		softAssertion.assertAll();
	}
	

}

//JavascriptExecutor js = (JavascriptExecutor) driver;
//js.executeScript("document.getElementById('//id of element').setAttribute('attr', '10')");