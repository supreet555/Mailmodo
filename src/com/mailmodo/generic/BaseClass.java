package com.mailmodo.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public static WebDriver driver;
	FileLib f = new FileLib();
	@BeforeClass
	public void openBrowser() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url = f.getPropertyData("url");
		driver.get(url);
	}
/*	
	@BeforeMethod
	public void login() throws IOException {
		String un = f.getPropertyData("email");
		String pwd = f.getPropertyData("password");
		driver.findElement(By.name("username")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("(//img[@alt='profile picture'])[1]")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
*/	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
