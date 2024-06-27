package Testcases;

import java.awt.Desktop.Action;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Baseclass.BaseClassEDIT;
import io.cucumber.core.gherkin.Argument;

public class TC002_Edit extends BaseClassEDIT {
@Test
	public void Editing() throws InterruptedException {
	
	   //9.Search for the Opportunity 'Salesforce Automation by Your Name'.
	WebElement searchbox =driver.findElement(By.xpath("//*[@name=\"Opportunity-search-input\"]"));
	searchbox.click();
	searchbox.sendKeys("Salesforce Automation by Baggiyam");
	searchbox.sendKeys(Keys.ENTER);
	Thread.sleep(10);
	
	    //10.Click on the Dropdown icon and select 'Edit'.
	//WebElement element2 = driver.findElement(By.xpath("//*[@class=\"forceVirtualActionMarker forceVirtualAction\" and @data-aura-class=\"forceVirtualAction\"][1]"));
	/*JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("argument[0].click()", element2);
	js1.executeScript("window.scrollBy(1000,0)");
	driver.findElement(By.xpath("//*[@data-target-selection-name=\"sfdc:StandardButton.Opportunity.Edit\" and @title=\"Edit\"]")).click();*/
	
	driver.findElement(By.xpath("//*[@id=\"brandBand_1\"]/div/div/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/table/tbody/tr[1]/td[8]/span/div/a")).click();
	driver.findElement(By.xpath("//span[text()='Edit']")).click();
	    //11.Choose the close date as Tomorrow's date
		
	WebElement closeDate=driver.findElement(By.xpath("//*[@class=\"slds-input\" and @name=\"CloseDate\"]"));
	LocalDate Currentdate=LocalDate.now();
	LocalDate tomorrowDate = Currentdate.plusDays(1);
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	closeDate.sendKeys(tomorrowDate.format(formatter));
	
	//12.Select 'Stage' as 'Perception Analysis'.
WebElement element=driver.findElement(By.xpath("//*[@type=\"button\"and @aria-label=\"Stage\"]"));
JavascriptExecutor js= (JavascriptExecutor)driver;
js.executeScript("arguments[0].click()",element );
driver.findElement(By.xpath("//span[@class='slds-truncate' and @title='Perception Analysis' ]")).click();
    //13.Select 'Delivery/Installation Status' as 'In Progress'.
driver.findElement(By.xpath("//*[@class=\"slds-form-element__label\" and contains(text(),\"Delivery/Installation Status\")]")).click();
driver.findElement(By.xpath("//*[@title=\"In progress\"]")).click();
    //14.Enter Description as 'SalesForce'.
driver.findElement(By.xpath("//*[@class=\"slds-form-element__label\" and contains(text(),\"Description\")]")).sendKeys("SalesForce");
    //15.Click on 'Save' and verify the Stage as 'Perception Analysis'.
driver.findElement(By.xpath("//*[@class=\"slds-button slds-button_brand\" and @name=\"SaveEdit\"]")).click();


	}
}
