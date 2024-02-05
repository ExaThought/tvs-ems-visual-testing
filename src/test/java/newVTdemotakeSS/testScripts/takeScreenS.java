package newVTdemotakeSS.testScripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;

import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import demoVTest.genric.Ratingpopup;
import demoVTest.genric.baseclass;
import demoVTest.genric.takeScreenShot;

public class takeScreenS extends baseclass{
	@Test(priority = 1 )
	public void saveSS() throws InterruptedException, IOException
	{
		int time = 2500 ;
		
		Thread.sleep(15000);
		   
	    takeScreenShot TakeScreenshot = new takeScreenShot();
	    		
	    		TakeScreenshot.takeScreenshot("homePage", driver);
	    
	    SearchContext shadow = driver.findElement(By.cssSelector("ion-menu-button[class='md button ion-activatable ion-focusable hydrated']")).getShadowRoot();
	    WebElement menuButton = shadow.findElement(By.cssSelector(".button-native"));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", menuButton);
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    SearchContext shadow1 = driver.findElement(By.cssSelector("ion-list:nth-child(1) > div:nth-child(9) > ion-menu-toggle:nth-child(1)>ion-item:nth-child(1)")).getShadowRoot();
	    WebElement LanguageSButton = shadow1.findElement(By.cssSelector(".item-native"));
	    Thread.sleep(time);
	    js.executeScript("arguments[0].click();", LanguageSButton);
	    
	    driver.findElement(By.xpath("/html/body")).click();
	    
	    Thread.sleep(time);
	    		
	    		TakeScreenshot.takeScreenshot("LanguagePage", driver);
	    
	    WebElement backbtn = driver.findElement(By.xpath("//*[@id=\"branch_manager\"]/app-language-selection/ion-header/ion-toolbar/div/div/ion-icon"));
	    backbtn.click();
	   
	    //handel rating popup 
	    Ratingpopup.rating(driver);
	      
	  
	   
	    
	    Thread.sleep(time);
	    SearchContext shadow2 = driver.findElement(By.cssSelector("ion-button[class='missed-task-btn md button button-solid ion-activatable ion-focusable hydrated']")).getShadowRoot();
	    WebElement MissedTaskButton = shadow2.findElement(By.cssSelector(".button-native"));
	    js.executeScript("arguments[0].click();", MissedTaskButton);
	    Thread.sleep(time);
	    
	    Thread.sleep(time);
	    		TakeScreenshot.takeScreenshot("missedtaskPage", driver);
	    
	    WebElement backbutton = driver.findElement(By.xpath("//*[@id=\"branch_manager\"]/app-branch-manager-todays-task/ion-header[2]/ion-toolbar[1]/div[1]/div"));
	    backbutton.click();
	    
	    WebElement filterButton = driver.findElement(By.xpath("//*[@id=\"branch_manager\"]/app-branch-manager-dashboard/ion-header[1]/ion-toolbar/div/div[2]/div[2]"));
	    filterButton.click();
	    Thread.sleep(2000);
	    
	    		TakeScreenshot.takeScreenshot("FilterPage", driver);
	    
	    WebElement backB = driver.findElement(By.xpath("//*[@id=\"branch_manager\"]/app-filters/ion-header/ion-toolbar[2]/div/div/ion-icon"));
	    backB.click();
	    
	    
	     SearchContext shadow3 = driver.findElement(By.cssSelector(".create-enq-btn.md.button.button-solid.ion-activatable.ion-focusable.hydrated")).getShadowRoot();
	    WebElement createEnquiryButton = shadow3.findElement(By.cssSelector(".button-native"));
	    Thread.sleep(time);
	    js.executeScript("arguments[0].click();",createEnquiryButton);
	    Thread.sleep(time);
	    		
	    		TakeScreenshot.takeScreenshot("CreateEnquiryPage", driver);
	}
}
