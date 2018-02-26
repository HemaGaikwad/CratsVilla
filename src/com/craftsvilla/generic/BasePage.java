package com.craftsvilla.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {

	
	public WebDriver driver;
	protected BasePage(WebDriver driver)
	{
	this.driver=driver;	
		
	}
	public void verifyTitle(String title)
	{
		WebDriverWait w=new WebDriverWait(driver,10);
		try{
			w.until(ExpectedConditions.titleContains(title));
			String text = driver.getTitle();
			Reporter.log(text,true);
			Reporter.log("pass",true);
		}
		catch(Exception e)
		{
			Reporter.log("fail",true);
			Assert.fail();
			
		}
	}
	public void verifyProductUrl(String s)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try{
			wait.until(ExpectedConditions.urlContains(s));
			Reporter.log("You are in correct page",true);
		}
		catch(Exception e)
		{
			Reporter.log("You are in wrong page");
            Assert.fail();		
		}
	}
	public void verifyElementPresent(WebElement ele)
	{
		WebDriverWait w=new WebDriverWait(driver,10);
		try{
			w.until(ExpectedConditions.visibilityOf(ele));
			Reporter.log("Element Present",true);
		}
		catch(Exception e)
		{
			Reporter.log("fail,element not present",true);
			Assert.fail();
		}
	}
	
	public void dropdownbyint(WebElement ele,int a)
	{
		Select s=new Select(ele);
		s.selectByIndex(a);
	}
	public void dropdownbyvalue(WebElement ele,String val)
	{
		Select s=new Select(ele);
		s.selectByValue(val);
	}
	public void dropdownbyvisibletext(WebElement ele,String text)
	{
		Select s=new Select(ele);
		s.selectByVisibleText(text);		
		}
	public void mouseMoveOver(WebDriver driver,WebElement ele)
	{
	Actions a=new Actions(driver);
	a.moveToElement(ele).perform();
	}

}



