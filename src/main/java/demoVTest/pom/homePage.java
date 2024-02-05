package demoVTest.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
@FindBy(xpath = "//*[@id=\\\"executive_manager\\\"]/app-executive-manager-dashboard/app-common-bottom-sticky-footer/ion-footer/ion-toolbar/div/ion-button[1]")
WebElement createEnqButton ;

public homePage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

public void ClickCreateEnqButton() {
	createEnqButton.click();
	
}


}
