package com.tvsAccelerator.genric;



import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.tvsAccelertor.pom.homePage;
import com.tvsAccelertor.pom.login_page;

public class baseclass {
public WebDriver driver ;

@BeforeTest
public void open_browser() throws InterruptedException{
	ChromeOptions ch = new ChromeOptions();
			ch.addArguments("--disable-notifications");
			ch.addArguments("--remote-debugging-port=9223");
			ch.addArguments("--user-data-dir=C:\\chrome-profile-bn");
	driver = new ChromeDriver(ch);		
	driver.manage().window().maximize();
	driver.get("https://uat-bgd.tvsmotor.net/login");
	Thread.sleep(500);
 }

@AfterTest
public void close_browser(){
		driver.quit();
}

@BeforeClass
public void login() throws Exception
{
	
	login_page login_page = new login_page(driver);

	login_page.setMobilenumbertext();
	
	login_page.nextButton(driver);

	login_page.setOpt1();
	login_page.setOpt2();
	login_page.setOpt3();
	login_page.setOpt4();
 
	login_page.Loginbtn(driver);   
		 
}
@AfterClass
public void logout() throws InterruptedException
{    
    
    homePage homepage = new homePage();
    homepage.menubutton(driver);
    homepage.logoutbutton(driver);
    
    
}
	
}
