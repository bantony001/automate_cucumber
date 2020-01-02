package com.amazon.dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.amazon.enums.DriverType;

public class ConfigFileReader {
	
	 private Properties properties;
	 private final String propertyFilePath= "configs//Configuration.properties";
	 	 
		public ConfigFileReader() {
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(propertyFilePath));
				properties = new Properties();
				try {
					properties.load(reader);
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch(FileNotFoundException e) {
				e.printStackTrace();
				throw new RuntimeException("Configuration properties not found at " + propertyFilePath);
			}
		}
	 
	 public String getDriverPath(){
		 String driverPath = properties.getProperty("driverPath");
		 if(driverPath!= null) return driverPath;
		 else throw new RuntimeException("driverPath not specified in the Configuration.properties file."); 
		 }
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) {
			return url;
		}
		else {
			throw new RuntimeException("driverPath not specified in Configuration.properties file");
		}

	}
	
	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
		else if(browserName.equals("firefox")) return DriverType.FIREFOX;
		else throw new RuntimeException("Browser Name Key value in configuration.properties is not matched : " + browserName);
	}
	
	public String getReportConfigPath(){
	 String reportConfigPath = properties.getProperty("reportConfigPath");
	 if(reportConfigPath!= null) return reportConfigPath;
	 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
	}

}
