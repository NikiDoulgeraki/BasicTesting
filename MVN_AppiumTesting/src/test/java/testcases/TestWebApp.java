package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class TestWebApp {

	public static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		
		/*
		 * platformName: android
		 * deviceName: Lenovo
		 * platformVersion: 5.0
		 * browser: Chrome
		 * device: android
		 */
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME , "Chrome"); //String, Object //1) basic for run
		capabilities.setCapability("deviceName","Lenovo K50a40"); //2) basic for run
		
		//capabilities.setCapability("device","Android");		
		//capabilities.setCapability("deviceName","Android"); --> this works either
		//capabilities.setCapability("platformVersion","5.0");
		//capabilities.setCapability("platformName","Android");
		
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
		
		driver.get("http://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Hello Appium !!!"); //q -> name of searchbox
		
		Thread.sleep(4000);
		
		driver.quit();

	}

}
