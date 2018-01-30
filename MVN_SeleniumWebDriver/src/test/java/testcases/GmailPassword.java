package testcases;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		//WebDriver driver= new FirefoxDriver();//Not Working
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://gmail.com");
		
	
		WebElement username=driver.findElement(By.id("identifierId"));
		username.sendKeys("nadoulgeraki@gmail.com");
		
		//tagname[@attribute='value']
		WebElement nextBtn=driver.findElement(By.xpath("//*[@id=\"identifierNext\"]"));
		nextBtn.click();
		
		//writing password
		WebDriverWait wait = new WebDriverWait(driver, 30);	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"password\"]/div[1]")));			
		WebElement password1=driver.findElement(By.name("password"));
		password1.sendKeys("bla");
			
		//click Next
		wait = new WebDriverWait(driver, 30);	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"passwordNext\"]/content/span")));
		WebElement nextBtn2=driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/content/span"));
		nextBtn2.click();
		
		//Getting Error
		/*Wait<WebDriver> wait2 = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS) //hitting element after 5 seconds, not all the time
				.withMessage("Timed out after 30 seconds user defined")
				.ignoring(NoSuchElementException.class);
	
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.name("jsname=\"B34EJ\"")));//xpath("*[@id=\"password\"]/div[2]/div[2]")));	
		WebElement wrongPass=driver.findElement(By.cssSelector("#password > div.LXRPh > div.dEOOab.RxsGPe"));
		System.out.println("Wrong Pass error: " +wrongPass.getText());
		*/
		
		driver.close();//close current page
		driver.quit();//close entire session
	}

}
