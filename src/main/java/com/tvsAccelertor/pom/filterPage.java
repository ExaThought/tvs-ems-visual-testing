package com.tvsAccelertor.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class filterPage {
@FindBy (xpath = "//*[@id='branch_manager']/app-filters/ion-header/ion-toolbar[2]/div/div/ion-icon")
WebElement backButton ;

public filterPage(WebDriver driver) {
	PageFactory.initElements(driver , this);
}

public void BackButton() {
backButton.click();	
}



}
