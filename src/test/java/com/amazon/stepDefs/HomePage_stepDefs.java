package com.amazon.stepDefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.SearchResultPage;
import com.amazon.dataProviders.ConfigFileReader;
import com.amazon.helper.Helper;
import com.amazon.manager.FileReaderManager;
import com.amazon.manager.PageObjectManager;
import com.amazon.manager.WebDriverManager;
import com.amazon.pages.AddToCartPage;
import com.amazon.pages.DeliveryAddressPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePage_stepDefs {
	
	HomePage homePage;
	SearchResultPage searchPage;
	ProductPage productPage;
	AddToCartPage atcPage;
	DeliveryAddressPage delAddPage;
	LoginPage loginPage;
	PageObjectManager pageObjectManager;
	ConfigFileReader configFileReader;
	
	Helper helper;
	
	WebDriver driver;
	String productName;
	String parentWinHandle;
	
	WebDriverManager webDriverManager;
	
	@Before
	public void setUp() {
		webDriverManager = new WebDriverManager();
		driver = webDriverManager.getDriver();
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
		driver.manage().window().maximize();		
		pageObjectManager = new PageObjectManager(driver);
	}
	
	@After
	public void closeBrowser() {
		driver.close();
        driver.switchTo().window(parentWinHandle);
        driver.close();
		System.out.println("Final Verification is successful");
	}
	
	@Given("^the user is in amazon page$")
	public void the_user_is_in_amazon_page() throws Throwable {
		homePage = pageObjectManager.getHomePage();
		homePage.verifyHomePage();		
	}

	@When("^the user searches for the product$")
	public void the_user_searches_for_the_product() throws Throwable {
		//productName = "Butterfly EKN 1.5-Litre Water Kettle (Silver with Black)";
		productName = "Inalsa Electric Kettle Select-1350W with 1 Litre Capacity, (Silver)";
		homePage.searchProduct(productName);
	}

	@Then("^the user should be able to navigate to the results page$")
	public void the_user_should_be_able_to_navigate_to_the_results_page() throws Throwable {
		searchPage= pageObjectManager.getSearchResultPage();
		searchPage.clickResult(productName);
	}
	
	@Then("^the user should be able to go to Products page$")
	public void the_user_should_be_able_to_go_to_Products_page() throws Throwable {
		productPage = pageObjectManager.getProductPage();
		parentWinHandle = driver.getWindowHandle();		
		helper = new Helper(driver);
		helper.switchToChildWindow(parentWinHandle);
		productPage.clickAddToCart();
	}
	
	@Then("^the user should be able to go to AddToCart Page$")
	public void the_user_should_be_able_to_go_to_AddToCart_Page() throws Throwable {
		atcPage = pageObjectManager.getAddToCartPage();
		atcPage.clickProceed();
	}

	@Then("^the user should be able to go to Login page$")
	public void the_user_should_be_able_to_go_to_Login_page() throws Throwable {
		loginPage = pageObjectManager.getLoginPage();
		String userName = "jamunaips666@gmail.com";
		String password = "Amazon#143";
		loginPage.enterUserCredentials(userName, password);
	}

	@Then("^the user should be able to go to Delivery Address page after entering the username and password$")
	public void the_user_should_be_able_to_go_to_Delivery_Address_page_after_entering_the_username_and_password() throws Throwable {
		delAddPage = pageObjectManager.getDeliveryAddressPage();
		delAddPage.verifyDeliveryPage("jamunaips");
	}
	
	@Then("^the user should be able to close the browser$")
	public void the_user_should_be_able_to_close_the_browser() throws Throwable {
	}
}	
