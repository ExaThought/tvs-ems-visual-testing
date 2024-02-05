package newVTdemocompareSS.testScripts;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;


import demoVTest.genric.Ratingpopup;
import demoVTest.genric.baseclass;
import demoVTest.genric.compareSS;

public class compareTest2 extends baseclass{
	public	compareSS compareSS = new compareSS(); 
	public int time = 1500 ;
	  @Test(priority=2)
	  public void compLanguagePage() throws InterruptedException, IOException{
		   
		  SearchContext shadow = driver.findElement(By.cssSelector("ion-menu-button[class='md button ion-activatable ion-focusable hydrated']")).getShadowRoot();
		    WebElement menuButton = shadow.findElement(By.cssSelector(".button-native"));
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		    JavascriptExecutor js = (JavascriptExecutor)driver;
		    js.executeScript("arguments[0].click();", menuButton);
		    
			Thread.sleep(time);
		  
		  SearchContext shadow1 = driver.findElement(By.cssSelector("ion-list:nth-child(1) > div:nth-child(9) > ion-menu-toggle:nth-child(1)>ion-item:nth-child(1)")).getShadowRoot();
		    WebElement LanguageSButton = shadow1.findElement(By.cssSelector(".item-native"));
		    Thread.sleep(time);
		   
		    js.executeScript("arguments[0].click();", LanguageSButton);
		    
		   
		    driver.findElement(By.xpath("/html/body")).click();
		   
		    Ratingpopup.rating(driver);
		    
			    Thread.sleep(time);
			    compareSS.compareScreenshot("LanguagePage",driver);
		    
	  }
	
}
