package com.pack.home.Libraries;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverLaunch {

	private WebDriver driver;
	String currentDir = System.getProperty("user.dir");
	
	public WebDriver openBrowser(String browser) {
		try {
			
			if (browser.equalsIgnoreCase("Firefox")) {
				System.out.println("Selected browser is Firefox");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.out.println("Selected browser is Chrome");
				System.setProperty("webdriver.chrome.driver",""+currentDir+""+"\\src\\main\\java\\com\\pack\\home\\AllDrivers\\chromedriver.exe");
				//System.setProperty("webdriver.chrome.driver", "C:\\NewProject-2017\\AutomationFramework\\src\\com\\pack\\home\\AllDrivers\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.out.println("Selected browser is Internet Explorer");
				System.setProperty("webdriver.ie.driver",""+currentDir+""+"\\src\\com\\pack\\home\\AllDrivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}

		//Maximize the window
		driver.manage().window().maximize();
			
		return driver;
	}
}
