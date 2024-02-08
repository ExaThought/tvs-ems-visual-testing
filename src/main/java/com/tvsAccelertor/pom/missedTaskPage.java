package com.tvsAccelertor.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class missedTaskPage {
	@FindBy(xpath="//*[@id=\"branch_manager\"]/app-branch-manager-todays-task/ion-header[2]/ion-toolbar[1]/div[1]/div")
	WebElement backbutton ;
    
	public missedTaskPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
	}

	public void Backbutton() {
		backbutton.click();
	}
	
	
	
}
