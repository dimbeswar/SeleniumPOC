package com.pack.home.Libraries;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;

import com.pack.home.ObjectRepositories.ExtractingDataFromPropertiesFile;

public class LibraryForGenericFunction extends ExtractingDataFromPropertiesFile{
	
	static Logger log = Logger.getLogger(LibraryForGenericFunction.class);
	String currentDir = System.getProperty("user.dir");
	WebDriver driver;
	public LibraryForGenericFunction(WebDriver driver){
		this.driver = driver;
	}
	public By locatorValue(String locatorTpye, String value) {
		By by;
		switch (locatorTpye.toLowerCase()) {
		case "id":
			by = By.id(value);
			break;
		case "name":
			by = By.name(value);
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		case "css":
			by = By.cssSelector(value);
			break;
		case "linktext":
			by = By.linkText(value);
			break;
		case "partiallinktext":
			by = By.partialLinkText(value);
			break;
		case "class":
		by =By.className(value);
		break;
		
		default:
			by = null;
			break;
		}
		return by;
	}



	public String toLowerCase(String locatorType){
		String locator = locatorType.toLowerCase();
		return locator;
	}
	
	public void waitAndClickForID(String ID,String fileName,String locatorType) throws InterruptedException, IOException{
		Thread.sleep(1000);
		Properties propsOfPage = extractData(fileName);
		String exe = propsOfPage.getProperty(ID);
		By locator;
		locator = locatorValue(locatorType, exe);
		boolean exists = driver.findElements(locator).size()!=0;
		if (exists==true){	
			log.info("Clicked webElement " +ID);
			driver.findElement(locator).click();
		}
		else{
			Assert.fail("Clickable Element is not present");
		}
	}
	
	public void waitAndSendKeysForID(String ID,String stringToSend,String fileName,String locatorType) throws InterruptedException, IOException{
		Thread.sleep(1000);
		Properties propsOfPage = extractData(fileName);
		String exe = propsOfPage.getProperty(ID);
		By locator;
		locator = locatorValue(locatorType, exe);
		boolean exists = driver.findElements(locator).size()!=0;
		if (exists==true){	
			log.info("Sent keys to text box " +ID);
			driver.findElement(locator).sendKeys(stringToSend);
		}else{
			Assert.fail("Text Box is not present");
		}
	}
	

}
