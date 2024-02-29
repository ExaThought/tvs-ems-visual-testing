package com.tvsAccelertor.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class language_Page {
@FindBy(xpath="//button[@id=\"alert-input-2-1\"]/div/div")
WebElement banglaLangRdButton ;

@FindBy(xpath = "//div[@class='alert-button-group sc-ion-alert-md']/button[2]")
WebElement selectbtn;

@FindBy(xpath="//*[@id=\"branch_manager\"]/app-language-selection/ion-header/ion-toolbar/div/div/ion-icon")
WebElement backbutton ;




public language_Page(WebDriver driver) {
PageFactory.initElements(driver, this );
}
	
public void BanglaLangRdButton() {
banglaLangRdButton.click();
}

public void Selectbtn() {
	   selectbtn.click();
}

public void backbutton() {
	   backbutton.click();
}



public void languagedropdown(WebDriver driver) {
SearchContext shadow2 = driver.findElement(By.cssSelector(".md.in-item.hydrated")).getShadowRoot();
WebElement langDropDown = shadow2.findElement(By.cssSelector("button[type='button']"));
JavascriptExecutor js = (JavascriptExecutor)driver;
js.executeScript("arguments[0].click();", langDropDown);
}

public void applybtn(WebDriver driver) {
	SearchContext shadow3 = driver.findElement(By.cssSelector("#branch_manager > app-language-selection > ion-content > div > div > ion-button")).getShadowRoot();
    WebElement applyBtn = shadow3.findElement(By.cssSelector(".button-native"));
    JavascriptExecutor js = (JavascriptExecutor)driver;
    js.executeScript("arguments[0].click();", applyBtn);
}
}