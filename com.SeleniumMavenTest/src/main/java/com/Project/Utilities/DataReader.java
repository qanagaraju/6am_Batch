package com.Project.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class DataReader {
	
	public Properties prop;
	
	public DataReader() {
		
		
		try {
			
			File file = new File("./AppFiles/data.properties");
			FileInputStream fis = new FileInputStream(file);
			
			 prop = new Properties();
			 prop.load(fis);
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("File Loaded successfully");
		}
		
	}

	
	//Create methods for repositories
	public String getunelement() {
		return prop.getProperty("unameelement");
	}
	
	public String getpwelement() {
		return prop.getProperty("pwelement");
	}
	
	public String getloginbuttonelement() {
		return prop.getProperty("loginbutton");
	}
	
	
	
	//Create default methods for each propertyname
	
	public String getchromebrowsersetup() {
		return prop.getProperty("chromebrowsersetup");
	}
	
	public String getchromebrowserdriver() {
		return prop.getProperty("chromebrowserdriver");
	}
	
	
	public String getchromebrowsername() {
		
		return prop.getProperty("chromebrowsername");
	}
	
	public String getbrowserurl() {
		
		return prop.getProperty("browserurl");
	}
	
	
	
	
	
	
	
	
	
}
