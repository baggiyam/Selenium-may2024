package Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Baseclass.BaseClassEDIT;

public class TC003_Delete extends BaseClassEDIT{
@Test
public void Delete() {

	//9.Search for the Opportunity 'Salesforce Automation by Your Name'.
		WebElement searchbox =driver.findElement(By.xpath("//*[@name=\"Opportunity-search-input\"]"));
		searchbox.click();
		searchbox.sendKeys("Salesforce Automation by Baggiyam");
		searchbox.sendKeys(Keys.ENTER);
		 //10.Click on the Dropdown icon and select 'Delete'.
		WebElement element2 = driver.findElement(By.xpath("//*[@class=\"forceVirtualActionMarker forceVirtualAction\" and @data-aura-class=\"forceVirtualAction\"][1]"));
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("argument[0].click()", element2);
		js1.executeScript("window.scrollBy(1000,0)");
		driver.findElement(By.xpath("//*[@data-target-selection-name=\"sfdc:StandardButton.Opportunity.Delete\" and @title=\"Delete\"]")).click();
		driver.findElement(By.xpath("//*[@title=\"Delete\" and @data-aura-class=\"uiButton--default uiButton--brand uiButton forceActionButton\"]")).click();
		
		String Sucessmessage = driver.findElement(By.xpath("//*[@class=\"slds-theme--success slds-notify--toast slds-notify slds-notify--toast forceToastMessage\"]")).getText();
		System.out.println(Sucessmessage);

		if(Sucessmessage.contains("was deleted")) {
			
			System.out.println("The entry got deleted");
		}
		
		
}
}
