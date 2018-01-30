package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GmailTitle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//WebDriver driver= new FirefoxDriver();//Not Working
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("http://www.gmail.com");
		
		//driver.navigate().back();
		driver.manage().window().maximize();
		
		//1st testcase is to compare actual title with expected.
		String actual_title=driver.getTitle();
		String expected_title="Yahoo.com";

		if(actual_title.equals(expected_title)) {
			System.out.println("true");
		}else
			System.out.println("false");
	
		//driver.close();
		//driver.quit();
	}

}
