package org.tcs.BasicTestCases;

import org.tcs.SetUpSuite.SeleniumSetup;
import org.testng.annotations.Test;


public class launchIRCTC extends SeleniumSetup{
	
	@Test
	public void IRCTCTest() throws InterruptedException {
		String FROM		=	"HYDERABAD DECAN - HYB (SECUNDERABAD)";
		String TO		=	"CHIRALA - CLX";
		
		launchIRCTCTest irctc	=	new launchIRCTCTest(driver,test);
		try {
			irctc.launchPage();
			irctc.waitForPageLoad();
			irctc.enterFromLocation(FROM);
			irctc.enterToLocation(TO);
			//driver.switchTo().alert().accept();//venky
			Thread.sleep(3000);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Test
	public void printMYname() {
		System.out.println("My name is Venky");
	}
	
}
