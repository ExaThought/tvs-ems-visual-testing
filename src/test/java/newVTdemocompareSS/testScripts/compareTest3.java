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

public class compareTest3 extends baseclass {
	public	compareSS compareSS = new compareSS(); 
	public int time = 2000 ;
	 @Test(priority=3)
	  public void compMissedtaskPage() throws InterruptedException, IOException{
		  Thread.sleep(time);
		    
		  SearchContext shadow2 = driver.findElement(By.cssSelector("ion-button[class='missed-task-btn md button button-solid ion-activatable ion-focusable hydrated']")).getShadowRoot();
		  WebElement MissedTaskButton = shadow2.findElement(By.cssSelector(".button-native"));
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    
		  js.executeScript("arguments[0].click();", MissedTaskButton);
		    
		    
		    	Thread.sleep(time);
		    	compareSS.compareScreenshot("missedtaskPage",driver);
		    
	  }
}
