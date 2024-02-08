package com.tvsaccelerator.testscripts;


import java.io.IOException;
import java.time.Duration;

import org.testng.annotations.Test;
import com.tvsAccelerator.genric.baseclass;
import com.tvsAccelerator.genric.compareSS;
import com.tvsAccelertor.pom.homePage;
import com.tvsAccelertor.pom.language_Page;


public class compareScreenshot extends baseclass{
	public int time =2000 ;
@Test(priority = 1)
public void comparehomePage() throws InterruptedException, IOException {
     
	homePage homepage = new homePage();
	homepage.menubutton(driver);
	homepage.languagebutton(driver);
    language_Page languagepage = new language_Page(driver);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    languagepage.languagedropdown(driver);
    languagepage.BanglaLangRdButton();
    Thread.sleep(time);
    languagepage.Selectbtn();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    languagepage.applybtn(driver);
    languagepage.backbutton();
	        
    		//Ratingpopup.rating(driver);
			Thread.sleep(time);
		    compareSS.compareScreenshot("homePage",driver);	
}

@Test(priority = 4)
public void compareLanguagePage() throws InterruptedException, IOException {
	homePage homepage = new homePage();
	homepage.menubutton(driver);
	homepage.languagebutton(driver);
	
			//Ratingpopup.rating(driver);
		    Thread.sleep(time);
		    compareSS.compareScreenshot("LanguagePage",driver);
			
}

@Test(priority = 3)
public void compareMissedtaskPage() throws InterruptedException, IOException {
	homePage homepage = new homePage();
	homepage.Missedtaskbutton(driver);
		    Thread.sleep(time);
		    compareSS.compareScreenshot("missedtaskPage",driver);
			
}
@Test(priority = 2)
public void comparefilterPage() throws InterruptedException, IOException
{
    homePage homepage = new homePage(driver);
    Thread.sleep(time);
	homepage.FilterButton();
			Thread.sleep(time);
		    compareSS.compareScreenshot("FilterPage",driver);
}
@Test(priority = 5)
public void comparecreateEnquiryPage() throws InterruptedException, Exception
{
	homePage homepage = new homePage();
	homepage.createEnquiryButton(driver);
			Thread.sleep(time);
			compareSS.compareScreenshot("CreateEnquiryPage",driver);
}



}
