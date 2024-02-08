package com.tvsAccelertor.pom;

import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tvsAccelerator.genric.Readdata;


public class login_page {
	@FindBy(xpath="//ion-button[@class='login-btn otp-btn md button button-block button-solid ion-activatable ion-focusable hydrated']")
	WebElement loginbtn ;
	
	@FindBy(xpath = "//input[@name='mobile']")
	WebElement mobilenumbertext ;
	
	@FindBy(xpath = "//input[@name='otpInput1']")
	WebElement otp1 ;
	
	@FindBy(xpath = "//input[@name='otpInput2']")
	WebElement otp2 ;
	
	@FindBy(xpath = "//input[@name='otpInput3']")
	WebElement otp3 ;
	
	@FindBy(xpath = "//input[@name='otpInput4']")
	WebElement otp4 ;
	
	public login_page(WebDriver driver){
		PageFactory.initElements( driver , this );
	}

	public void setOpt1() throws IOException {
		String otp0 = Readdata.readpropertydata("otp1");
		otp1.sendKeys(otp0);
	}


	public void setOpt2() throws IOException {
		String otp1 = Readdata.readpropertydata("otp2");
		otp2.sendKeys(otp1);
	}


	public void setOpt3() throws IOException {

		String otp2 = Readdata.readpropertydata("otp3");
		otp3.sendKeys(otp2);
	}
	public void setOpt4() throws Exception {

		String otp3 = Readdata.readpropertydata("otp4");
		otp4.sendKeys(otp3);
	}


	public void setLoginbtn(WebElement loginbtn) {
		this.loginbtn = loginbtn;
	}


	public void setMobilenumbertext(WebElement mobilenumbertext) {
		this.mobilenumbertext = mobilenumbertext;
	}


	public void setMobilenumbertext() throws IOException {
		String mobilenumber = Readdata.readpropertydata("id");
		mobilenumbertext.sendKeys(mobilenumber);
	}

	public void Loginbtn(WebDriver driver) throws InterruptedException {
		WebElement logbtn = loginbtn; 
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].scrollIntoView();", logbtn);
		Thread.sleep(500);
		logbtn.click(); 
	}
	
	
	public void nextButton(WebDriver driver) {
		 SearchContext shadow = driver.findElement(By.cssSelector(".login-btn.md.button.button-block.button-solid.ion-activatable.ion-focusable.hydrated")).getShadowRoot();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 	WebElement nextButton = shadow.findElement(By.cssSelector(".button-inner"));
		 	JavascriptExecutor js = (JavascriptExecutor)driver;
		    js.executeScript("arguments[0].click();", nextButton);
	}
	
	
	
}
