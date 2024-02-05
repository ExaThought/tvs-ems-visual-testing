package newVTdemocompareSS.testScripts;

import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;


import demoVTest.genric.baseclass;
import demoVTest.genric.compareSS;

public class compareTest4 extends baseclass{
	public	compareSS compareSS = new compareSS(); 
	public int time = 1500 ;
	  @Test(priority=4)
	  public void createEnquiryPage() throws InterruptedException, IOException{
		  	
		  Thread.sleep(time);
		  SearchContext shadow30 = driver.findElement(By.cssSelector(".create-enq-btn.md.button.button-solid.ion-activatable.ion-focusable.hydrated")).getShadowRoot();
		  WebElement createEnquiryButton = shadow30.findElement(By.cssSelector(".button-native"));
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  JavascriptExecutor js = (JavascriptExecutor)driver;  
		  Thread.sleep(time);
		  js.executeScript("arguments[0].click();",createEnquiryButton);
		    
			    Thread.sleep(time);
			    compareSS.compareScreenshot("CreateEnquiryPage",driver);	
		    
	  }
}
