package com.amazon.manager;

import org.openqa.selenium.WebDriver;

import com.amazon.pages.AddToCartPage;
import com.amazon.pages.DeliveryAddressPage;
import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.SearchResultPage;

public class PageObjectManager {

	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private SearchResultPage searchPage;
	private AddToCartPage atcPage;
	private DeliveryAddressPage deliveryPage;
	private ProductPage productPage;
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomePage getHomePage() {
		return (homePage == null)? homePage = new HomePage(driver):homePage;
	}

	public LoginPage getLoginPage() {
		return (loginPage == null)? loginPage = new LoginPage(driver):loginPage;
	}
	
	public SearchResultPage getSearchResultPage() {
		return (searchPage == null)? searchPage = new SearchResultPage(driver):searchPage;
	}
	
	public AddToCartPage getAddToCartPage() {
		return (atcPage == null)? atcPage = new AddToCartPage(driver):atcPage;
	}
	
	public DeliveryAddressPage getDeliveryAddressPage() {
		return (deliveryPage == null)? deliveryPage = new DeliveryAddressPage(driver):deliveryPage;
	}	
	
	public ProductPage getProductPage() {
		return (productPage == null)? productPage = new ProductPage(driver):productPage;
	}	
	
}
