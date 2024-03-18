package org.tcs.BasicTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tcs.AllXpaths.classesXpaths;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import WebActions.webactions;

public class launchIRCTCTest implements classesXpaths{
	WebDriver driver;
	webactions actions;
	ExtentTest test;
	public launchIRCTCTest(WebDriver Driver,ExtentTest Test) {
		super();
		driver			=	Driver;
		actions			=	new webactions(driver);
		test			=	Test;
	}
	
	public void launchPage() {
		String url			=	"https://www.irctc.co.in/nget/train-search";
		try {
			driver.get(url);
			System.out.println("URL is lauched Successfully..");
			test.log(LogStatus.PASS, "URL is lauched Successfully..");
		}catch(Exception e) {
			System.out.println("Unable to launch page "+e.getMessage());
			test.log(LogStatus.FAIL, "Unable to launch page");
		}
	}
	public boolean waitForPageLoad() {
		try {
			String pageLoad		=	IRCTC_LOGO;
			if(actions.WaitForPageToLoad(pageLoad)) {
				System.out.println("Page is loaded Successfully..");
				test.log(LogStatus.PASS, "Page is loaded Successfully");
			}
		}catch(Exception e) {
			System.out.println("Unable to load page "+e.getMessage());
			test.log(LogStatus.FAIL, "Unable to load page");
		}
		return false;
	}
	public void enterFromLocation(String ComingFrom) {
		String From			=	FROM;
		try {
			if(actions.verifyElementPresentAndClearEnterText(From,ComingFrom)) {
				System.out.println(ComingFrom+" is entered");
				test.log(LogStatus.PASS, ComingFrom+" is entered Successfully");
			}else {
				System.out.println("unable to enter "+ComingFrom);
				test.log(LogStatus.FAIL, " Unable to entered "+ComingFrom);
			}
		}catch(Exception e) {
			System.out.println("unable to enter "+ComingFrom+" "+e.getMessage());
			test.log(LogStatus.FAIL, " Unable to entered "+ComingFrom);
		}
	}
	public void enterToLocation(String ComingTo) {
		String To			=	TO;
		try {
			if(actions.verifyElementPresentAndClearEnterText(To,ComingTo)) {
				System.out.println(ComingTo+" is entered");
				test.log(LogStatus.PASS, ComingTo+" is entered Successfully");
			}else {
				System.out.println("unable to enter "+ComingTo);
				test.log(LogStatus.FAIL, " Unable to entered "+ComingTo);
			}
		}catch(Exception e) {
			System.out.println("unable to enter "+ComingTo+" "+e.getMessage());
			test.log(LogStatus.FAIL, " Unable to entered "+ComingTo);
		}
	}
	
}
