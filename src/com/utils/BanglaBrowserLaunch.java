package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BanglaBrowserLaunch {
	public static WebDriver bangladriver;
	
	@Test
	
	public void oepnBrowser()
	{
		  ChromeOptions chromeOptions1 = new ChromeOptions();
	        chromeOptions1.addArguments("--remote-debugging-port=9223");
	        chromeOptions1.addArguments("--user-data-dir=C:\\chrome-profile-bn");
	        chromeOptions1.addArguments("--lang=bn");

	        // Instantiate ChromeDriver with options
	        bangladriver = new ChromeDriver(chromeOptions1);

	        // Open a website (replace "https://example.com" with your desired URL)
	        bangladriver.navigate().to("https://uat-bgd.tvsmotor.net/login");
	}

}
