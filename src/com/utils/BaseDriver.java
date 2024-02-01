package com.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
	
	
	public static WebDriver driver;
	public static ExtentReports extent;
    public static ExtentTest testCase;
    public static ExtentSparkReporter spark;
	
	@BeforeSuite
	public static void StartBrowser()
	
	{
		 String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("./Output/TestReports_" + timestamp + ".html");
        extent.attachReporter(spark);
        
       

       
        
		driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		
	}
	
	@AfterSuite
	public static void CloseBrowser()
	{
		extent.flush();
		driver.close();
		
	}
	
	
}
