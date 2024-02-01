package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class NormalBrowserLaunch {
	public static WebDriver normaldriver;
	@Test
	
	public void OpenBrowser()
	{
		
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-debugging-port=9222");
        chromeOptions.addArguments("--user-data-dir=C:\\chrome-profile-normal");
       

        // Instantiate ChromeDriver with options
        normaldriver = new ChromeDriver(chromeOptions);

        // Open a website (replace "https://example.com" with your desired URL)
        normaldriver.navigate().to("https://uat-bgd.tvsmotor.net/sales-executive-dashboard");
	}

}
