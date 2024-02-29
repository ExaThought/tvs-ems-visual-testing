package com.tvsaccelerator.testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.tvsAccelerator.genric.baseclass;
import com.tvsAccelerator.genric.takeScreenShot;
import com.tvsAccelertor.pom.filterPage;
import com.tvsAccelertor.pom.homePage;
import com.tvsAccelertor.pom.language_Page;
import com.tvsAccelertor.pom.missedTaskPage;
import com.tvsAccelerator.genric.Ratingpopup;


public class takescreenshot extends baseclass{
	@Test()
	public void saveSS() throws InterruptedException, IOException
	{
		int time = 2500 ;
		Thread.sleep(15000);
		
		takeScreenShot TakeScreenshot = new takeScreenShot();
 		homePage homepage = new homePage(driver);
 		language_Page languagePage = new language_Page(driver);
 		missedTaskPage missedtaskpage = new missedTaskPage(driver);
 		filterPage filterPage = new filterPage(driver);
 		Thread.sleep(time);
 		
				TakeScreenshot.takeScreenshot("homePage", driver);
	    
		homepage.menubutton(driver);
		homepage.languagebutton(driver);
		Thread.sleep(time);
		
		
				TakeScreenshot.takeScreenshot("LanguagePage", driver);
						
	    languagePage.backbutton(); 
		Ratingpopup.rating(driver);
		Thread.sleep(time);
		        
		homepage.Missedtaskbutton(driver);
		Thread.sleep(time);
 		
				TakeScreenshot.takeScreenshot("missedtaskPage", driver);
		
		missedtaskpage.Backbutton();
		Thread.sleep(time);
		homepage.FilterButton();
		Thread.sleep(time);
	    
				TakeScreenshot.takeScreenshot("FilterPage", driver);
				
		filterPage.BackButton();
		homepage.createEnquiryButton(driver);
		Thread.sleep(time);
 		
 				TakeScreenshot.takeScreenshot("CreateEnquiryPage", driver);

}
}