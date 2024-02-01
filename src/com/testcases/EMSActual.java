package com.testcases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.compare.ComparableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.HasCdp;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.pageobjects.DashboardPageObjects;
import com.utils.ComparisionUtility;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class EMSActual {
	public static WebDriver driver;
	
	public void handleRating()
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
	public void captureActual() throws Exception {
		ChromeOptions chromeOptions1 = new ChromeOptions();
		chromeOptions1.addArguments("--remote-debugging-port=9223");
		chromeOptions1.addArguments("--user-data-dir=C:\\chrome-profile-bn");
		// chromeOptions1.addArguments("window-size=1285,865");

		// Instantiate ChromeDriver with options
		driver = new ChromeDriver(chromeOptions1);
	
		DashboardPageObjects dp = new DashboardPageObjects(driver);

		driver.navigate().to("https://uat-bgd.tvsmotor.net/login");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(dp.Inputfield));

		/*
		 * // Get the current date and time LocalDateTime now = LocalDateTime.now();
		 * DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
		 * String timestamp = now.format(formatter);
		 */
		
		//Login Page
		
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000))
				.takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "png", new File("./ActualResult/ActualImages/Login.png"));
		WebElement Inputfiled = driver.findElement(By.xpath("//input[@class='native-input sc-ion-input-md']"));
		Inputfiled.sendKeys("1111111111");

		WebElement loginbtnhost = driver.findElement(By
				.cssSelector(".login-btn.md.button.button-block.button-solid.ion-activatable.ion-focusable.hydrated"));
		SearchContext loginbtnroot = loginbtnhost.getShadowRoot();

		WebElement loginbtn = loginbtnroot.findElement(By.cssSelector(".button-native"));
		wait.until(ExpectedConditions.visibilityOf(loginbtn));
		Actions login = new Actions(driver);
		login.moveToElement(loginbtn).click().perform();
		wait.until(ExpectedConditions.visibilityOf(dp.otp1));

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
		
		wait.until(ExpectedConditions.visibilityOf(dp.summaryHeading));
		
		// ---to click hamburger menu------
		
		WebElement menuHost = driver.findElement(By.cssSelector("ion-menu-button[class='md button ion-activatable ion-focusable hydrated']"));
		SearchContext menuRoot = menuHost.getShadowRoot();

		WebElement Menu = menuRoot.findElement(By.cssSelector(".button-native"));

		Actions a1 = new Actions(driver);
		a1.moveToElement(Menu).click().perform();

		//wait.until(ExpectedConditions.visibilityOf(dp.Logo));
		Thread.sleep(2000);
		
		handleRating();
		
		WebElement langSettingHost = driver.findElement(By.cssSelector("ion-list>div:nth-child(6)>ion-menu-toggle:nth-child(1) > ion-item:nth-child(1)"));
		SearchContext langSettingRoot = langSettingHost.getShadowRoot();
		WebElement langSetting = langSettingRoot.findElement(By.cssSelector(".item-native"));

		Actions a2 = new Actions(driver);
		a2.moveToElement(langSetting).click().perform();
		
		handleRating();
	
		//Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(dp.LanguageSelect));
		dp.LanguageSelect.click();

		//WebElement parentElement2 = driver.findElement(By.cssSelector(".language-settings"));
		
		/*
		 * Actions a3 = new Actions(driver);
		 * a3.moveToElement(dp.LanguageSelect).click().perform();
		 */
		/*
		 * WebElement Lang = driver.findElement(By.cssSelector(
		 * "body > app-root:nth-child(1) > ion-app:nth-child(1) > ion-alert:nth-child(2) > div:nth-child(2) > div:nth-child(3) > button:nth-child(2) > div:nth-child(1) > div:nth-child(1)"
		 * ));
		 */
		
		handleRating();
		
		wait.until(ExpectedConditions.visibilityOf(dp.Lang));
		
		dp.Lang.click();
		
		handleRating();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
		dp.Select.click();
		
		handleRating();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement applyHost = driver.findElement(By.cssSelector("body > app-root:nth-child(1) > ion-app:nth-child(1) > div:nth-child(1) > ion-split-pane:nth-child(1) > ion-router-outlet:nth-child(2) > app-language-selection:nth-child(3) > ion-content:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ion-button:nth-child(1)"));
		SearchContext applyRoot = applyHost.getShadowRoot();
		WebElement ApplyBtn = applyRoot.findElement(By.cssSelector(".button-native"));

		Actions a5 = new Actions(driver);
		a5.moveToElement(ApplyBtn).click().perform();
		
		handleRating();     
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		dp.BackArrow.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//------Navigating to enquiry reports page-------------

		driver.navigate().to("https://uat-bgd.tvsmotor.net/summary-reports");
		
		wait.until(ExpectedConditions.visibilityOf(dp.TotalEnquiries));
		handleRating();
		
		//-----------Capture Screenshot of Enquiry reports page
		
		screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000))
				.takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "png", new File("."+File.separator+"ActualResult"+File.separator+"ActualImages"+File.separator+"Dashboard.png"));

		//-----------Navigate to total enquiry report and capture screenshot---------
		
		dp.TotalEnquiries.click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		Screenshot screenshot1 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
		ImageIO.write(screenshot1.getImage(), "png", new File("."+File.separator+"ActualResult"+File.separator+"ActualImages"+File.separator+"TotalEnquiries.png"));
		dp.BackArrow1.click();

		Thread.sleep(2000);
		handleRating();

		
		DashboardPageObjects.NotFollowedUpEnquiries.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Screenshot screenshot2 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000)).takeScreenshot(driver);
		ImageIO.write(screenshot2.getImage(), "png", new File("."+File.separator+"ActualResult"+File.separator+"ActualImages"+File.separator+"NotFollowedUpEnquiries.png"));
		dp.BackArrow1.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		handleRating();

		DashboardPageObjects.FollowedUpEnquiries.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		Screenshot screenshot3 = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(2000))
				.takeScreenshot(driver);
		ImageIO.write(screenshot3.getImage(), "png", new File("."+File.separator+"ActualResult"+File.separator+"ActualImages"+File.separator+"FollowedUpEnquiries.png"));
		dp.BackArrow1.click();
		
		handleRating();
 
		ComparisionUtility.CompareImages();
		
	}
}
