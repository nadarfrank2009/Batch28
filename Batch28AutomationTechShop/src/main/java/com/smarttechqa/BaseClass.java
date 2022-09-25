package com.smarttechqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class BaseClass {

	static WebDriver driver;


	@BeforeTest
	public static void setUp() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://www.smarttechqa.com");

		driver.manage().window().maximize();

	}

	@Test
	public static void Validaation() throws InterruptedException {
		
		driver.get("https://www.smarttechqa.com/login");

		driver.findElement(By.id("email")).sendKeys("test@gmail.com");

		driver.findElement(By.id("password")).sendKeys("Smarttechpassword2022");
		
		//driver.findElement(By.cssSelector("#password")).sendKeys("Smarttechpassword2022");

		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

		Thread.sleep(300);
		
		Assert.assertEquals("https://www.smarttechqa.com/", driver.getCurrentUrl());

	}

	@AfterTest
	public static void TearDown() {
		driver.quit();
		System.out.println("close");
	}

}
