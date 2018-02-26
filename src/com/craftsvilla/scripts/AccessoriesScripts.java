package com.craftsvilla.scripts;

import org.testng.annotations.Test;

import com.craftsvilla.generic.BaseTest;
import com.craftsvilla.pom.AccessoriesProductPage;

public class AccessoriesScripts extends BaseTest
{
	
	@Test
	public void AddWatchToCart()
	{
		
		AccessoriesProductPage ap = new AccessoriesProductPage(driver);
		ap.gotoAcccessories();
		ap.clickOn();
		ap.clickOnProduct();
		ap.addToCart();
		
		
	}
	

}
