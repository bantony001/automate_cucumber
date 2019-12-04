package com.amazon.pages;

import com.amazon.helper.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
	Helper helper;
	WebDriver driver;
	By searchBox = By.xpath("//input[@id='twotabsearchtextbox' and @class ='nav-input']");
	By submitButton = By.xpath("//input[@class='nav-input' and @type='submit']");
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickAddToCart() throws InterruptedException {
		String parentWinHandle = driver.getWindowHandle();		
		helper = new Helper(driver);
		helper.switchToChildWindow(parentWinHandle);
		System.out.println("Product Page Verification");
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(3000);
	}
}
