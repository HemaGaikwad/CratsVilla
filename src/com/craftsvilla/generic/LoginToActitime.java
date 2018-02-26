package com.craftsvilla.generic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginToActitime
{
	WebDriver driver = null;
	String PATH = "/Users/ramu.gaikward/Documents/Personel/Hema/Framework/CraftsVillaAutomation/TestData/CredentialsForActitime.xlsx";
	public void login()
	{
	System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
	driver= new ChromeDriver();
	driver.get("https://online.actitime.com/s7880/login.do");

	String uname = ExcelData.getCellValue(PATH, "LoginToApp", "TD_Username", 1);
	String password = ExcelData.getCellValue(PATH, "LoginToApp", "TD_Password", 1);
	
	driver.findElement(By.id("username")).sendKeys(uname);
	driver.findElement(By.name("pwd")).sendKeys(password);
	driver.findElement(By.xpath("//div[text()='Login ']")).click();
	}
	

}
