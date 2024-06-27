package Baseclass;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Baseclass {
	public static ChromeDriver driver;
	@BeforeMethod
	public void Precondition(){
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
		//geeting the URL 
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		//Enter the username = 
		driver.findElement(By.xpath("//*[@class=\"input r4 wide mb16 mt8 username\" and @id=\"username\"]")).sendKeys("gokul.sekar@testleaf.com");
		//Enter the Password  =
		driver.findElement(By.xpath("//*[@class=\"input r4 wide mb16 mt8 password\" and @id=\"password\"]")).sendKeys("Leaf$123");
		//Click on Login
		driver.findElement(By.xpath("//*[@class=\"button r4 wide primary\" and @id=\"Login\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
	@AfterMethod
	public void Postcondition(){
	//	driver.quit();
	}
}
