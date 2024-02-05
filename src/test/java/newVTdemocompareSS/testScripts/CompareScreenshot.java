package newVTdemocompareSS.testScripts;

import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;


import demoVTest.genric.Ratingpopup;
import demoVTest.genric.baseclass;
import demoVTest.genric.compareSS;



public class CompareScreenshot extends baseclass{
	public	compareSS compareSS = new compareSS(); 
	public int time = 2000 ;
  @Test(priority = 1)
  public void compHomePageSS () throws Exception {
	    
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
	    
	    SearchContext shadow2 = driver.findElement(By.cssSelector(".md.in-item.hydrated")).getShadowRoot();
	    WebElement langDropDown = shadow2.findElement(By.cssSelector("button[type='button']"));
	    js.executeScript("arguments[0].click();", langDropDown);
	    
	    WebElement banglaLangRdBTN = driver.findElement(By.xpath("//*[@id=\"alert-input-2-1\"]/div/div[2]"));
	    banglaLangRdBTN.click();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    WebElement selectBTN = driver.findElement(By.xpath("//*[@id=\"ion-overlay-2\"]/div/div[4]/button[2]"));
	    selectBTN.click();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    
	    SearchContext shadow3 = driver.findElement(By.cssSelector("#branch_manager > app-language-selection > ion-content > div > div > ion-button")).getShadowRoot();
	    WebElement applyBtn = shadow3.findElement(By.cssSelector(".button-native"));
	    js.executeScript("arguments[0].click();", applyBtn);
	   
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    
	    WebElement backbtn = driver.findElement(By.xpath("//*[@id=\"branch_manager\"]/app-language-selection/ion-header/ion-toolbar/div/div/ion-icon"));
	    backbtn.click();
	   
	        Ratingpopup.rating(driver);
	        Thread.sleep(time);
		    compareSS.compareScreenshot("homePage",driver);
	       
  }
  
  
  
  
}
