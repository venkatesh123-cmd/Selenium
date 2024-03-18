package org.tcs.BasicTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tcs.AllXpaths.classesXpaths;


public class youtube implements classesXpaths{
	
	public void launchUrl(WebDriver driver) {
		String url		=	"https://www.youtube.com";
		try {
			driver.get(url);
			System.out.println("Youtube page has loaded properly");
		}catch(Exception e) {
			System.out.println("Unable to launch youtube page");
			e.printStackTrace();
		}
	}
	public boolean DoesElementExist(WebDriver driver,String xpathpath) {
		WebDriverWait wait 			=	new WebDriverWait(driver,Duration.ofSeconds(10));
		boolean flagvalue			=	false;
		try {
			WebElement flag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathpath)));
			flagvalue       =   flag.isDisplayed();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flagvalue;
	}
	/*public void EnterTextValue(WebDriver driver) {
		String Text					=	"Okkadu Movie Songs Mahesh Babu";
		//String YoutubeSearchBox		=	YoutubeSearchBar;
		try {
			if(DoesElementExist(driver,YoutubeSearchBox)) {
				driver.findElement(By.xpath(YoutubeSearchBox)).sendKeys(Text);
				System.out.println(Text+" is entered in youtube search box ");
			}else {
				System.out.println("Unable to find element :"+YoutubeSearchBox);
			}
		}catch(Exception e) {
			System.out.println("Unable to enter text in youtube page");
			e.printStackTrace();
		}
	}*/
}
