package com.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.pageobjects.DashboardPageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class EMSExpected {

	public static WebDriver driver;
	
	public static void handleRating()
	{
		DashboardPageObjects dp = new DashboardPageObjects(driver);
		try
		{if (dp.Rating.isDisplayed())
			{  
			  WebElement ratingCancelHost = driver.findElement(By.cssSelector(".border-right.md.button.button-block.button-solid.ion-activatable.ion-focusable.hydrated" )); 
			  SearchContext ratingCancelRoot = ratingCancelHost.getShadowRoot();
			  WebElement ratingCancel =ratingCancelRoot.findElement(By.cssSelector(".button-native"));
			  Actions clickRatingCancel =new Actions(driver);
			  clickRatingCancel.moveToElement(ratingCancel).click().perform();	
			}
		     
		}
		catch(Exception e)
		{
			System.out.println("popup not displayed");
			//e.printStackTrace();
		}
		
	}

	@Test

	public static void loginTest() throws InterruptedException, IOException {

		ChromeOptions chromeOptions1 = new ChromeOptions();
		chromeOptions1.addArguments("--remote-debugging-port=9223");
		chromeOptions1.addArguments("--user-data-dir=C:\\chrome-profile-bn");
		driver = new ChromeDriver(chromeOptions1);
		driver.manage().window().maximize();
		
		DashboardPageObjects dp = new DashboardPageObjects(driver);

		driver.get("https://uat-bgd.tvsmotor.net/login");
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(dp.Inputfield));
		
		//----------------Login Page------------------------
		
		
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000))
				.takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "png", new File("."+File.separator+"ExpectedResult"+File.separator+"ExpectedImages"+File.separator+"Login.png"));
		
		dp.Inputfield.sendKeys("1111111111");
		
		WebElement loginbtnhost = driver.findElement(By.cssSelector(".login-btn.md.button.button-block.button-solid.ion-activatable.ion-focusable.hydrated"));
		SearchContext loginbtnroot = loginbtnhost.getShadowRoot();

		WebElement loginbtn = loginbtnroot.findElement(By.cssSelector(".button-native"));

		WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait1.until(ExpectedConditions.visibilityOf(loginbtn));
		
		
		Actions login = new Actions(driver);
		login.moveToElement(loginbtn).click().perform();
		wait1.until(ExpectedConditions.visibilityOf(dp.otp1));
		//----------------Enter OTP Page---------------
		
		dp.otp1.sendKeys("5");
		dp.otp2.sendKeys("4");
		dp.otp3.sendKeys("2");
		dp.otp4.sendKeys("7");
		
		WebElement enterButtonHost = driver.findElement(By.cssSelector(".login-btn.otp-btn.md.button.button-block.button-solid.ion-activatable.ion-focusable.hydrated"));
		SearchContext enterButtonRoot = enterButtonHost.getShadowRoot();

		WebElement enterButton = enterButtonRoot.findElement(By.cssSelector(".button-native"));
		Actions clickEnterBtn =new Actions(driver);
		clickEnterBtn.moveToElement(enterButton).click().perform();
		
		wait1.until(ExpectedConditions.visibilityOf(dp.summaryHeading));
		
		//--------------navigate to enquiry reports page-----------------
        
		driver.navigate().to("https://uat-bgd.tvsmotor.net/summary-reports");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		handleRating();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "png", new File("."+File.separator+"ExpectedResult"+File.separator+"ExpectedImages"+File.separator+"Dashboard.png"));

		//-------------click Total Enquiry--------------------
		
		dp.TotalEnquiries.click();
		System.out.println("clicked totalEnquiries");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000))
				.takeScreenshot(driver);
		ImageIO.write(screenshot1.getImage(), "png", new File("."+File.separator+"ExpectedResult"+File.separator+"ExpectedImages"+File.separator+"TotalEnquiries.png"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//div[@class='custome-back-arrow'])[2]")).click();

		
		Thread.sleep(4000);
		handleRating();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(DashboardPageObjects.NotFollowedUpEnquiries));
		DashboardPageObjects.NotFollowedUpEnquiries.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		  Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver); 
		  ImageIO.write(screenshot2.getImage(), "png", new File("."+File.separator+"ExpectedResult"+File.separator+"ExpectedImages"+File.separator+"NotFollowedUpEnquiries.png"));
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.findElement(By.xpath("(//div[@class='custome-back-arrow'])[2]")).click();
		  
		  Thread.sleep(5000);
		  wait1.until(ExpectedConditions.visibilityOf(DashboardPageObjects.FollowedUpEnquiries));
		
		  DashboardPageObjects.FollowedUpEnquiries.click();		  
		//dp.FollowedUpEnquiries.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Screenshot screenshot3 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
		ImageIO.write(screenshot3.getImage(), "png", new File("."+File.separator+"ExpectedResult"+File.separator+"ExpectedImages"+File.separator+"FollowedUpEnquiries.png"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//div[@class='custome-back-arrow'])[2]")).click();
		  

		

	}

}
