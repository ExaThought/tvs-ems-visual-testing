package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeBrowserSwitchCode {
	
	public static WebDriver normaldriver;
	public static WebDriver bangladriver;
	
	
	
	public static void main(String args[])
	{
		
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-debugging-port=9222");
        chromeOptions.addArguments("--user-data-dir=C:\\chrome-profile-bn");
       

        // Instantiate ChromeDriver with options
        normaldriver = new ChromeDriver(chromeOptions);

        // Open a website (replace "https://example.com" with your desired URL)
        normaldriver.navigate().to("https://uat-bgd.tvsmotor.net/sales-executive-dashboard");
        
        ChromeOptions chromeOptions1 = new ChromeOptions();
        chromeOptions1.addArguments("--remote-debugging-port=9223");
        chromeOptions1.addArguments("--user-data-dir=C:\\chrome-profile-bn");
        chromeOptions1.addArguments("--lang=bn");

        // Instantiate ChromeDriver with options
        bangladriver = new ChromeDriver(chromeOptions1);

        // Open a website (replace "https://example.com" with your desired URL)
        bangladriver.navigate().to("https://www.google.com");
	}
	
	@Test
	
	public static void BanglaBrowser()
	{
		
		
	}

}
