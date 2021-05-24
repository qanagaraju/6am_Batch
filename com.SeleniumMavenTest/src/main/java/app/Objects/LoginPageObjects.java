package app.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Project.Utilities.DataReader;



public class LoginPageObjects {
	
	public static WebDriver driver;
	public static DataReader reader = new DataReader();
	
	
	//Create constructor variable for the class
	public LoginPageObjects(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	public void verifyusername(String un) {
		
		//sending keys to userid
				driver.findElement(By.name(reader.getunelement())).sendKeys(un);
		
	}
	
	
	
	public void verifypassword(String pw) {
		
		
		driver.findElement(By.name(reader.getpwelement())).sendKeys(pw);
		
	}
	
	
	public void verifyloginbutton() {
		
		//clicking login button
				WebElement loginbutton = driver.findElement(By.name(reader.getloginbuttonelement()));
				if(loginbutton.isEnabled()) {
					loginbutton.click();
					System.out.println("Login Button enabled");
					
					
					try {
						
						String error = driver.findElement(By.id("right_col_top_err")).getText();
						System.out.println("Login error message"+"\t"+error);
						System.out.println("Login Fail");
						
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}finally {
						System.out.println("Login error");
					}
					
					
					
				}
				else
				{
					System.out.println("Login button is disabled");
				}
	}
	
	
	
	
	
	public void verifysignout() {
		
		
		try {
			WebElement signout = driver.findElement(By.xpath("//*[@id=\"user_bar\"]/ul/li[1]/a"));
			if(signout.isEnabled()) {
				signout.click();
				System.out.println("Login success");
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}finally {
			System.out.println("verify login account");
		}
		
		
	}
	

}
