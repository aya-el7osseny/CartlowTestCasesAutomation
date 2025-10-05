package CartlowTestCasesAutomation;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Login_testcase {
	WebDriver chromeDriver;
	 
	@Test
  public void login_testcase () {
		chromeDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[1]/div/div[1]/div[3]/div[3]/span/span[2]")).click();
		chromeDriver.findElement(By.xpath("//*[@id=\"app\"]/header/div[1]/div/div[1]/div[3]/div[3]/div/div/div[2]/a[1]")).click();
		
		WebDriverWait wait = new WebDriverWait(chromeDriver, (10));
		WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"identifier\"]")));
		emailField.sendKeys("aya.el7osseny@gmail.com");
		
		
		WebElement continue_btn= chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div/div/div/form/div[2]/button"));
		
		
		JavascriptExecutor java=(JavascriptExecutor)chromeDriver;
		java.executeScript("scroll(0, 250)"); 
		continue_btn.click();
		
		WebDriverWait waitPassowrd = new WebDriverWait(chromeDriver, (10));
		WebElement passwordField= waitPassowrd.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password\"]")));
		passwordField.sendKeys("Aya@1234");
		

		WebElement login_btn= chromeDriver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div[2]/div/div/div/form/div[2]/button"));
		JavascriptExecutor java1=(JavascriptExecutor)chromeDriver;
		java1.executeScript("scroll(0, 250)"); 
		login_btn.click();
		
		
		WebDriverWait waitAccountName = new WebDriverWait(chromeDriver, (10));
		WebElement accountLabel = waitAccountName.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"app\\\"]/header/div[1]/div/div[1]/div[3]/div[3]/div/div/div[1]/p[1]")));
		String expecteNameAccount= accountLabel.getText();
		
			Assert.assertEquals(expecteNameAccount, " Ayoya Elhosseny");
			
  }
	

	@BeforeClass
	public void open_browser()
	{
	    System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
		chromeDriver=new ChromeDriver();
		chromeDriver.get("https://cartlow.com/uae/en");
		
	}
	
	@AfterClass
	public void close_browser()
	{
		chromeDriver.close();
		
	}
	
}
	
