package com.Bankingproject;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class AppLoginTest 
{
	public static WebDriver driver;
	
	//How to run test cases from jenkins server
	//Download jenkins war file
	
	//How to push this project to git hub server

	public static ExtentReports extent;
	public static ExtentTest test;
	
	@BeforeSuite
	public void setupAppSuite() {
		extent=new ExtentReports("./AppReports/projectreport.html");
		test = extent.startTest("Simple Jenkins Test");
		
	}
	
	
	
	@BeforeTest
	public void launchbrowser() {
		
		
		System.setProperty("webdriver.chrome.driver", "./AppDrivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.mycontactform.com/");
		System.out.println("Launching browser");
		
	}
	
    
	@Test
    
    public void verifyinvalidlogin()
    {
    	
    	
		driver.findElement(By.name("user")).sendKeys("tester");
		System.out.println("Enter username");
		test.log(LogStatus.INFO, "Enter User Name");
		
		driver.findElement(By.name("pass")).sendKeys("admin123");
    	System.out.println("Enter password");
    	test.log(LogStatus.INFO, "Enter password");
		
		WebElement loginbutton = driver.findElement(By.name("btnSubmit"));
		System.out.println("Click button");
		test.log(LogStatus.INFO, "verify button");

		if(loginbutton.isEnabled()) {
			loginbutton.click();
			System.out.println("Login Button verified");
			test.log(LogStatus.INFO, "Login Button verified");
		}
		else
		{
			System.out.println("Does not verified");
		}
			
        
    }
    
    
 
	
    
    @AfterTest
    public void closebrowser() {
    	
    	driver.close();
    	
    	//extent.close();
      	extent.flush();
    	
    	
    }
    
    
}
