package com.pack.home.TestExecution;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import com.pack.home.Libraries.DriverLaunch;
import com.pack.home.Libraries.LibraryForGenericFunction;
//import com.pack.sd.star.Reporting.CustomReporter;


public class TestRun {
	DriverLaunch Dlib = new DriverLaunch(); 
	public static WebDriver driver;
	LibraryForGenericFunction lib = null;
	
	@BeforeTest
	public void executingTEP ()  throws InterruptedException, IOException {
		driver = Dlib.openBrowser("chrome");
		lib = new LibraryForGenericFunction(driver);
		// Now the application link will be opened
				driver.get("https://www.facebook.com/");
				
	}
	@Test(priority=1)
	public void login() throws InterruptedException, IOException{
		System.out.println("Pass");
		lib.waitAndSendKeysForID("username", "dimbe@rediffmail.com", "login", "ID");
		lib.waitAndSendKeysForID("password", "pranjoli123", "login", "ID");		
	}
	@Test(priority=2)
	public void loginclick() throws InterruptedException, IOException{
		lib.waitAndClickForID("login", "login", "ID");
	}
	
}
