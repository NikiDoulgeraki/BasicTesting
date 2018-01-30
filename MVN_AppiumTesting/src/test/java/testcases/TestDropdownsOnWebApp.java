package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestDropdownsOnWebApp {

	public static AndroidDriver <WebElement> driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		//starting the Appium server code //not working
		/*AppiumDriverLocalService service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
				.usingDriverExecutable(new File("C:\\Users\\niki-aimilia\\Desktop\\Appium\\node-v8.9.4-win-x64\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\niki-aimilia\\AppData\\Local\\Programs\\appium-desktop\\resources\\app\\node_modules\\appium\\lib\\appium.js")));	
		
		service.start();
		*/
		
		//For testing wikipedia	 
		  DesiredCapabilities capabilities = new DesiredCapabilities();
		  capabilities.setCapability(CapabilityType.BROWSER_NAME , "Chrome");
		  capabilities.setCapability("deviceName","Lenovo K50a40");
		  //capabilities.setCapability("app",app.getAbsolutePath());
		  
		  driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		  
		 // driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		  
		  driver.get("http://www.wikipedia.org");
		  
		  driver.manage().deleteAllCookies();
		
		WebElement dropdown = driver.findElement(By.id("searchLanguage"));
		//new Select(dropdown).selectByVisibleText("Dansk");
		Select select =new Select(dropdown);
		select.selectByValue("hi");
		//select.getOptions();
		
		
		System.out.println("--- Printing Languages ---");
		List<WebElement> values=dropdown.findElements(By.tagName("option"));
		
		for(WebElement value: values)
		{
			System.out.println(value.getAttribute("lang"));
		}
		
		System.out.println("--- Printing Links ---");
		
		WebElement block=driver.findElement(By.xpath("//*[@id=\"www-wikipedia-org\"]/div[6]/div[3]"));
		
		List<WebElement> links=block.findElements(By.tagName("a"));
		
		for(WebElement link: links)
		{
			System.out.println(link.getAttribute("href")+ "----" +link.getText());
		}
		
		Thread.sleep(2000);
		
		//driver.quit();
		 
		
		//For testing app
/*		
		//For creating the app
		//File app = new File("C:\\Users\\niki-aimilia\\Desktop\\SELENDROID\\selendroid-test-app.apk");
		//capabilities.setCapability("app",app.getAbsolutePath());
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName","Lenovo K50a40"); 
		capabilities.setCapability(CapabilityType.PLATFORM, "Windows");
		
		capabilities.setCapability("app", "C:\\Users\\niki-aimilia\\Desktop\\SELENDROID\\selendroid-test-app.apk");
		//capabilities.setCapability("app-package", "io.selendroid.testapp");
		//capabilities.setCapability("app-activity", "HomeScreenActivity");
		
		driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.findElement(By.id("io.selendroid.testapp:id/my_text_field")).sendKeys("Hello selendroid");;
		
		Thread.sleep(2000);
		
		driver.quit();
		//service.stop();
		*/

	}


}
