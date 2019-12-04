package com.amazon.stepDefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.SearchResultPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class homePage_stepDefs {
	WebDriver driver;
	HomePage homePage;
	SearchResultPage searchPage;
	ProductPage productPage;
	String productName;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\eclipse-workspace\\lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();		
	}
	
	@Given("^the user is in amazon page$")
	public void the_user_is_in_amazon_page() throws Throwable {
		homePage = new HomePage(driver);
		homePage.verifyHomePage();		
	}

	@When("^the user searches for the product$")
	public void the_user_searches_for_the_product() throws Throwable {
		productName = "Butterfly EKN 1.5-Litre Water Kettle (Silver with Black)";
		homePage.searchProduct(productName);
	}

	@Then("^the user should be able to navigate to the results page$")
	public void the_user_should_be_able_to_navigate_to_the_results_page() throws Throwable {
		searchPage=new SearchResultPage(driver);
		searchPage.clickResult(productName);
	}
	
	@Then("^the user should be able to go to Products page$")
	public void the_user_should_be_able_to_go_to_Products_page() throws Throwable {
		productPage = new ProductPage(driver);
		productPage.clickAddToCart();
	}

	@Then("^the user should be able to go to Login page$")
	public void the_user_should_be_able_to_go_to_Login_page() throws Throwable {
		LoginPage loginPage = new LoginPage(driver);
		String userName = "test1";
		String password = "pwd";
		loginPage.enterUserCredentials(userName, password);
	}

	@Then("^the user should be able to go to Delivery Address page after entering the username and password$")
	public void the_user_should_be_able_to_go_to_Delivery_Address_page_after_entering_the_username_and_password() throws Throwable {
	}
}	
