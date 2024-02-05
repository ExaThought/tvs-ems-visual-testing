package newVTdemocompareSS.testScripts;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import demoVTest.genric.baseclass;
import demoVTest.genric.compareSS;

public class compareTest5 extends baseclass{
	public	compareSS compareSS = new compareSS(); 
	public int time = 2000 ;
	
	 @Test(priority=5)
	  public void compFilterPage() throws InterruptedException, IOException{
		 	
		 Thread.sleep(time);
		  WebElement filterButton = driver.findElement(By.xpath("//*[@id=\"branch_manager\"]/app-branch-manager-dashboard/ion-header[1]/ion-toolbar/div/div[2]/div[2]"));
		  Thread.sleep(time);
		  //not working
		  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		  filterButton.click();
		 
		    
			    Thread.sleep(time);
			    compareSS.compareScreenshot("FilterPage",driver);
		    
		    
		    
		    
		    
		    
			
	  }
}
