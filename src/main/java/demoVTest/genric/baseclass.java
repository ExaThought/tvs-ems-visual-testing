package demoVTest.genric;



import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class baseclass {
public WebDriver driver ;
public JavascriptExecutor js = (JavascriptExecutor)driver;

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
public void login() throws InterruptedException, IOException
{
	Readdata Readdata = new Readdata();
	String mobilenumber = Readdata.readpropertydata("id");
	String otp1 = Readdata.readpropertydata("otp1");
	String otp2 = Readdata.readpropertydata("otp2");
	String otp3 = Readdata.readpropertydata("otp3");
	String otp4 = Readdata.readpropertydata("otp4");
	driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobilenumber);
	 SearchContext shadow = driver.findElement(By.cssSelector(".login-btn.md.button.button-block.button-solid.ion-activatable.ion-focusable.hydrated")).getShadowRoot();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 	WebElement loginButton = shadow.findElement(By.cssSelector(".button-inner"));
	 	JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", loginButton);
	    driver.findElement(By.xpath("//input[@name='otpInput1']")).sendKeys(otp1);
	    driver.findElement(By.xpath("//input[@name='otpInput2']")).sendKeys(otp2);
	    driver.findElement(By.xpath("//input[@name='otpInput3']")).sendKeys(otp3);
	    driver.findElement(By.xpath("//input[@name='otpInput4']")).sendKeys(otp4);
	    
	   
	    WebElement loginbtn = driver.findElement(By.xpath("//ion-button[@class='login-btn otp-btn md button button-block button-solid ion-activatable ion-focusable hydrated']"));
	    js.executeScript("arguments[0].scrollIntoView();", loginbtn);
	    Thread.sleep(500);
	    loginbtn.click(); 
		 
}
@AfterClass
public void logout() throws InterruptedException
{    
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    SearchContext shadow123 = driver.findElement(By.cssSelector("ion-menu-button[class='md button ion-activatable ion-focusable hydrated']")).getShadowRoot();
    WebElement menuButton = shadow123.findElement(By.cssSelector(".button-native"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click();", menuButton);
    Thread.sleep(500);
    
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    SearchContext shadow122 = driver.findElement(By.cssSelector("ion-item[class='ion-no-padding item-label item md in-list ion-focusable hydrated']")).getShadowRoot();
    WebElement LogoutBtn = shadow122.findElement(By.cssSelector(".input-wrapper"));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    js.executeScript("arguments[0].click();", LogoutBtn);
    Thread.sleep(500);
    
}
	
}
