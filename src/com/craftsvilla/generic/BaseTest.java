package com.craftsvilla.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements AutoConst
{
	public static WebDriver driver;
	
	@BeforeMethod
	public void openApp()
	{
		System.setProperty(chrome_key, chrome_value);
		driver = new ChromeDriver();
		driver.get("http://www.craftsvilla.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	/*@AfterMethod
	public void closeApp()
	{
		driver.quit();
		
	}*/
	
	

}
