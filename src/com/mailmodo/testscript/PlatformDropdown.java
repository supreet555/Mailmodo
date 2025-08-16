package com.mailmodo.testscript;
import org.openqa.selenium.TimeoutException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mailmodo.generic.BaseClass;
import com.mailmodo.generic.FileLib;

@Listeners(com.mailmodo.generic.ListenerImplementation.class)
public class PlatformDropdown extends BaseClass{
	
	@FindBy(xpath="//span[text()='Platform']")
	WebElement pltDropdown;
	
	@FindBy(xpath="(//div[@class='styles_leftCol__RcLH8']//p[@class='styles_title__Oiskg'])")
	List<WebElement> dropdownItems;
	
	public PlatformDropdown() {
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public void checkPageDisplayed() throws Exception {
		PlatformDropdown pd = new PlatformDropdown();
		Actions a = new Actions(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		FileLib f = new FileLib();
		for(int i=0; i<pd.dropdownItems.size(); i++) {
			a.moveToElement(pd.pltDropdown).perform();
			pd.dropdownItems.get(i).click();
			String eTitle = f.getExcelData("Page Titles", i+1, 1);
			try {
				wait.until(ExpectedConditions.titleIs(eTitle));
				String aTitle = driver.getTitle();
				if(aTitle.equals(eTitle)) {
					f.setExcelData("Page Titles", i+1, 2, "Pass");
				} else {
					f.setExcelData("Page Titles", i+1, 2, "Fail");			
				}
			 } catch(TimeoutException te) {
				 f.setExcelData("Page Titles", i+1, 2, "Fail");
			 }
		}
		
	}
}
