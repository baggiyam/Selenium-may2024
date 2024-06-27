package Testcases;
import Baseclass.Baseclass;
import Utils.ReadExcel;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TC001_Create extends Baseclass {
	
	@DataProvider(name="Login and create")
	public String[][] sendData() throws IOException
	{
		return ReadExcel.ReadData();
	}
	
	@Test(dataProvider="Login and create")

	
	public void Create(String OpportunityName,String Amount) throws InterruptedException {
		// Click on the toogle option on the left ::
				driver.findElement (By.xpath("//div[@class=\"slds-icon-waffle\"]")).click();
				//cling on the veiw all option s
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.findElement(By.xpath("//*[@class=\"slds-button\" and @aria-label=\"View All Applications\"]")).click();
				//Clicking on the sales Option 
				driver.findElement (By.xpath("//p[text()=\"Sales\"]")).click();
				//click on oppercunity" tab 
				//WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
				//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Opportunities\"]/parent::*[@class=\"slds-context-bar__label-action dndItem\"]")));
				driver.findElement(By.xpath("//div[@class='slds-combobox slds-dropdown-trigger slds-dropdown-trigger_click']"));
			    
				//using javascript executor clicking on the Opportunities
			    WebElement element=driver.findElement(By.xpath("//*[text()=\"Opportunities\"]/parent::*[@class=\"slds-context-bar__label-action dndItem\"]"));
			    JavascriptExecutor js= (JavascriptExecutor)driver;
			    js.executeScript("arguments[0].click()", element);
			    //click on the new option
			    driver.findElement(By.xpath("//div[@title=\"New\"]")).click();
			    //10.Enter the Opportunity name as '"Salesforce Automation by Baggiyam"', get the text, and store it.
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			    driver.findElement(By.xpath("//*[@class=\"slds-input\" and @name=\"Name\"]")).sendKeys(OpportunityName);
			    // 11. Enter Amount as 75,000 
			    driver.findElement(By.xpath("//*//*[@class=\"slds-input\" and @name=\"Amount\"]")).sendKeys(Amount);
			    //12.Choose the close date as Today.
			    LocalDate currentDate = LocalDate.now();
			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			    //LocalDate tomorrowDate = currentDate.plusDays(1);

			    driver.findElement(By.xpath("//*[@class=\"slds-input\" and @name=\"CloseDate\"]")).sendKeys(currentDate.format(formatter));
			    //13.Select 'Stage' as 'Need Analysis'.
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			   // driver.findElement(By.xpath("//*[@aria-describedby=\"help-text-267\"]")).click();
			   // WebDriverWait wait = new WebDriverWait(driver, 10);
			 
		        //WebElement element2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id =\"combobox-button-265\" and @aria-describedby=\"help-text-264\"]")));
			    

		        WebElement element2 =driver.findElement (By.xpath("//*[@class = \"slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value\" and @aria-label=\"Stage\"]"));
		    
		       JavascriptExecutor js1= (JavascriptExecutor)driver;
			    js1.executeScript("arguments[0].click()", element2);
			   // WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
 // Wait up to 10 seconds
			    //wait.until(ExpectedConditions.elementToBeClickable(element2));
			    driver.findElement(By.xpath("//span[@class='slds-truncate' and @title='Needs Analysis' ]")).click();
			    
			    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			   
				  //span[@class='slds-truncate' and @title='Needs Analysis' ]
			    
			    //14.Click on the 'Save' button and verify the Opportunity Name.
			   driver.findElement(By.xpath("//*[@class=\"slds-button slds-button_brand\" and @name=\"SaveEdit\"]")).click();
			   OpportunityName=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
			    
			    System.out.println(OpportunityName);
			    
			    if(OpportunityName.contains("Baggiyam"))
			    {
			    	System.out.println("Opportunity name is correct");
			    }
				
			    else
			    {
			    	System.out.println("Opportunity name is incorrect");
			    }

	}
}

	
	
	



