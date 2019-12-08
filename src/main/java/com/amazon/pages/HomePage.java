package com.amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	By searchBox = By.xpath("//input[@id='twotabsearchtextbox' and @class ='nav-input']");
	By submitButton = By.xpath("//input[@class='nav-input' and @type='submit']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void verifyHomePage() throws InterruptedException {
		System.out.println("Initial Verification is successful");
		driver.findElement(By.xpath("//span[contains(text(), 'Deliver to')]")).isDisplayed();
	}
	
	public void searchProduct(String productName) throws InterruptedException {
		driver.findElement(searchBox).sendKeys(productName);
		driver.findElement(submitButton).click();
		Thread.sleep(3000);
	}
}
