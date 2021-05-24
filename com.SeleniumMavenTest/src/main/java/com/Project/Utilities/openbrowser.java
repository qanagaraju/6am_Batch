package com.Project.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class openbrowser {
	
	public static WebDriver driver;
	public static DataReader readdata = new DataReader();
	
	public static WebDriver InvokeBrowser(String browsername,String browserurl) {
		
		if(browsername.equals("chrome")) {
			
			System.setProperty(readdata.getchromebrowsersetup(), readdata.getchromebrowserdriver());
			driver=new ChromeDriver();
			
			/*
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--chrome");
			options.addArguments("--start-fullscreen");
			
			chromedriver = new ChromeDriver(options);
			*/
			
		}else if(browsername.equals("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", "./AppDrivers/geckodriver.exe");
			driver=new FirefoxDriver();
			
		}else if(browsername.equals("edge")) {
			
			System.setProperty("webdriver.edge.driver", "./AppDrivers/msedgedriver.exe");
			driver=new EdgeDriver();
			
		}
			
		
		
		
		driver.get(browserurl);
		
		if(browserurl.equalsIgnoreCase(driver.getCurrentUrl())) {
			System.out.println("URL verified-Step passed");
		}
		else
		{
			System.out.println("Not verified - Step failed");
		}
		
		
		
		
		System.out.println("Page Title is...."+driver.getTitle());
		
		System.out.println("======================================");
		
		
		return driver;
		
	}
	
	
	public static void closebrowser() {
		
		driver.quit();
		
		
	}

}
