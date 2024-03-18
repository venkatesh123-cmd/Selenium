package org.tcs.BasicTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.tcs.SetUpSuite.SeleniumSetup;
import org.testng.Assert;
import org.testng.annotations.Test;

public class javascriptexe extends SeleniumSetup{
	
	@Test
	public void scrollInto(){
		driver.get("https://testsigma.com/blog/scrolling-in-selenium/");
		JavascriptExecutor jse	=	(JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,3000)");
		//Assert.assertEquals(0, 0,"Test case is passed");
	}
}
