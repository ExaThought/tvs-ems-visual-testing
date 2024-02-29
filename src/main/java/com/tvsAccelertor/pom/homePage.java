package com.tvsAccelertor.pom;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
   public int time =2000 ;
	@FindBy(xpath = "(//div[@class='icon-div header'])[1]")
	WebElement filterButton ;
	public homePage() {}
	
	public homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

	
	public void FilterButton() throws InterruptedException {
		Thread.sleep(time);
		filterButton.click();
	}


	public void menubutton(WebDriver driver) throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    SearchContext shadow123 = driver.findElement(By.cssSelector("ion-menu-button[class='md button ion-activatable ion-focusable hydrated']")).getShadowRoot();
	    WebElement menuButton = shadow123.findElement(By.cssSelector(".button-native"));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", menuButton);
	    Thread.sleep(500);
	}
	
	public void languagebutton(WebDriver driver) throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    SearchContext shadow1 = driver.findElement(By.cssSelector("ion-list:nth-child(1) > div:nth-child(9) > ion-menu-toggle:nth-child(1)>ion-item:nth-child(1)")).getShadowRoot();
	    WebElement LanguageSButton = shadow1.findElement(By.cssSelector(".item-native"));
	    Thread.sleep(time);
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", LanguageSButton);
	    
	    driver.findElement(By.xpath("/html/body")).click();
	}
	
	
	
	public void logoutbutton(WebDriver driver) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    SearchContext shadow122 = driver.findElement(By.cssSelector("ion-item[class='ion-no-padding item-label item md in-list ion-focusable hydrated']")).getShadowRoot();
	    WebElement LogoutBtn = shadow122.findElement(By.cssSelector(".input-wrapper"));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", LogoutBtn);
	    Thread.sleep(500);
	}
	
	public void Missedtaskbutton(WebDriver driver)
	{
	  SearchContext shadow2 = driver.findElement(By.cssSelector("ion-button[class='missed-task-btn md button button-solid ion-activatable ion-focusable hydrated']")).getShadowRoot();
	  WebElement MissedTaskButton = shadow2.findElement(By.cssSelector(".button-native"));
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));   
	  js.executeScript("arguments[0].click();", MissedTaskButton);
	}
	
	public void createEnquiryButton(WebDriver driver) throws InterruptedException
	{
	  SearchContext shadow30 = driver.findElement(By.cssSelector(".create-enq-btn.md.button.button-solid.ion-activatable.ion-focusable.hydrated")).getShadowRoot();
	  WebElement createEnquiryButton = shadow30.findElement(By.cssSelector(".button-native"));
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  JavascriptExecutor js = (JavascriptExecutor)driver;  
	  Thread.sleep(time);
	  js.executeScript("arguments[0].click();",createEnquiryButton);
	}
}
