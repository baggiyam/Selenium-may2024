package Baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

public class BaseClassEDIT extends Baseclass{
	@BeforeMethod
public void Edit() {
		super.Precondition();
		
            // Additional setup specific to BaseClassEDIT
       
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
	    
}
}
