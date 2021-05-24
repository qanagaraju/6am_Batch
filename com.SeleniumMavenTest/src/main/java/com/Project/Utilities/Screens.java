package com.Project.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Screens {
	
	
	
	public static String getscreen(WebDriver driver,String screename) throws IOException {
		
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File file = element.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("./Screens/"+screename+".png");
		
		String destpath = dest.getAbsolutePath();
		
		FileUtils.copyFile(file,dest);
		
		return destpath;
		
		
		
	}
	

}
