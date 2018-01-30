package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WikipediaDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.wikipedia.org/");
		
		//************ First way of selecting element in dropdown ************//
		
		/*	WebElement selectLanguage=driver.findElement(By.id("searchLanguage"));
		selectLanguage.click();		
		selectLanguage.sendKeys("English");
		selectLanguage.click();*/
		
		//************ Second way of selecting element in dropdown ************//
		
		//First way of getting the elements of a dropdown
		Select elm = new Select(driver.findElement(By.id("searchLanguage")));
		elm.selectByVisibleText("English");
		//elm.selectByValue("hi"); //in case of difficult language that is not readable
		
		List<WebElement> options=  elm.getOptions();
		
		for(WebElement we: options) {
			System.out.println(we.getText());
		}
		System.out.println(options.size());	
	
		
		//Second way of getting the elements of a dropdown
		
		/*System.out.println("-------------------Printing all dropdown values-------------------");
		
		List<WebElement> option= driver.findElements(By.tagName("option"));
	
		for(WebElement we2: option) {
			System.out.println(we2.getAttribute("lang"));
		}
		System.out.println(option.size());	*/
	
		//************** Printing all links**************//
	/*	System.out.println("-------------------Printing all Links -------------------");
		
		//Printing links from particular block
		List<WebElement> block = driver.findElements(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[1]"));
		
		//Printing links from entire webpage
		//List<WebElement> links= driver.findElements(By.tagName("a"));
		for(WebElement we3: block links) {
			System.out.println(we3.getText());
		}*/
	}

}
