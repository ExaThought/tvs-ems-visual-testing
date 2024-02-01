package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPageObjects {
	
	public static WebDriver driver;
	
	/*
	 * @FindBy(xpath="//img[@src='assets/images/tvs-branding.svg']") public
	 * WebElement Logo;
	 */
	@FindBy(xpath="//input[@class='native-input sc-ion-input-md']")
	public WebElement Inputfield;
	
	@FindBy(xpath="(//input[@class='native-input sc-ion-input-md'])[1]") 
	public WebElement otp1;
	
	@FindBy(xpath="(//input[@class='native-input sc-ion-input-md'])[2]") 
	public WebElement otp2 ;
	
	@FindBy(xpath="(//input[@class='native-input sc-ion-input-md'])[3]") 
	public WebElement otp3;
	
	@FindBy(xpath="(//input[@class='native-input sc-ion-input-md'])[4]") 
	public WebElement otp4 ;
	
	@FindBy(xpath="//div[@class=\"summary-heading\"]") 
	public WebElement summaryHeading;
	
	@FindBy(xpath="//img[@src='assets/images/tvs-branding.svg']") 
	public WebElement Logo;
	
	@FindBy(xpath="//ion-menu-button[@class=\"md button ion-activatable ion-focusable hydrated\"]")
	public WebElement HamburgerMenu;
	
	@FindBy(css=".language-settings")
	public WebElement LanguageSelect;
	
	@FindBy(css="body > app-root:nth-child(1) > ion-app:nth-child(1) > ion-alert:nth-child(2) > div:nth-child(2) > div:nth-child(3) > button:nth-child(2) > div:nth-child(1) > div:nth-child(1)")
	public WebElement Lang;
	
	@FindBy(xpath="//span[normalize-space()='Select']")
	public WebElement Select;
	
	@FindBy(xpath="//span[normalize-space()='নির্বাচন করুন']")
	public WebElement BanglaSelect;
	
	@FindBy(xpath="//ion-label[contains(text(),'আবেদন করুন')]")
	public WebElement BanglaApply;
	
	
	@FindBy(xpath="(//div[@class='total-enq'])[1]")
	public WebElement TotalEnquiries ;
	
	@FindBy(xpath="(//div[@class='total-enq'])[2]")
	public static WebElement NotFollowedUpEnquiries;
	
	@FindBy(xpath="(//div[@class='total-enq'])[3]")
	public static WebElement FollowedUpEnquiries;
	
	@FindBy(xpath="//div[text()=' Followed Up Enquiries']")
	public static WebElement FollowedUpEnq;
	
	@FindBy(xpath="(//div[@class='total-enq'])[4]")
	public WebElement ConvertedEnquiries ;
	
	@FindBy(xpath="(//div[@class='total-enq'])[5]")
	public WebElement PostponedEnquiries;
	
	@FindBy(xpath="(//div[@class='total-enq'])[6]")
	public WebElement LostAndDropped;
	
	@FindBy(css="label[for='se-menu-accordion-2']")
	public WebElement Reports;
	
	@FindBy(xpath="//div[@class='custome-back-arrow']") 
	public WebElement BackArrow;
	
	@FindBy(xpath="(//div[@class='custome-back-arrow'])[2]") 
	public WebElement BackArrow1;
	
	@FindBy(xpath="//div[@class='app-rating-popup']") 
	public WebElement Rating;
	
	/*
	 * WebElement loginbtnhost = driver.findElement(By.cssSelector(
	 * ".login-btn.md.button.button-block.button-solid.ion-activatable.ion-focusable.hydrated"
	 * )); SearchContext loginbtnroot = loginbtnhost.getShadowRoot(); public
	 * WebElement loginbtn
	 * =loginbtnroot.findElement(By.cssSelector(".button-native"));
	 */
    
	

	public DashboardPageObjects(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

}
