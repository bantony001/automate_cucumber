package com.amazon.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.enums.DriverType;

public class WebDriverManager {

	private WebDriver driver;
	private static DriverType driverType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FF_DRIVER_PROPERTY = "webdriver.gecko.driver";
	
	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
	}
	
	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}
	
	public WebDriver createDriver() {
		switch(driverType) {
		case CHROME: 
			System.setProperty(CHROME_DRIVER_PROPERTY, System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigReader().getDriverPath() + "chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty(FF_DRIVER_PROPERTY, System.getProperty("user.dir") + FileReaderManager.getInstance().getConfigReader().getDriverPath() + "geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		return driver;
	}

}
