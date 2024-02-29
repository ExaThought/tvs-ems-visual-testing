package com.tvsAccelerator.genric;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Ratingpopup {
 
public static void rating(WebDriver driver) 
{
	try {
		 long time = 500;
		Thread.sleep(time );
		SearchContext shadow222 = driver.findElement(By.cssSelector("div.pop-up-button-grp > ion-button.border-right.md.button.button-block.button-solid.ion-activatable.ion-focusable.hydrated")).getShadowRoot();
	    WebElement cancleButton = shadow222.findElement(By.cssSelector(".button-native"));
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	    JavascriptExecutor js = (JavascriptExecutor) driver ;
	    js.executeScript("arguments[0].click();", cancleButton);
	   
		
	} catch (Exception e) {
		
	} 
}	
	
}
 