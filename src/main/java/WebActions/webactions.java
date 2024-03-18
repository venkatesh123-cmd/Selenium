package WebActions;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class webactions {
	WebDriver driver = null;
	public webactions(WebDriver Driver) {
		super();
		this.driver	=	Driver;
	}
	public void verifyElementPresentandScrollToElement(String name,String locator) {
		for(int i=0;;i++) {
			if(i>10) {
				break;
			}
			try {
				if(waitForElement(locator)) {
					WebElement WE			=	driver.findElement(By.xpath(locator));
					JavascriptExecutor js	=	(JavascriptExecutor)driver;
					js.executeScript("arguments[0].scrollIntoView(true);", WE);
					break;
				}
			}catch(Exception e) {
				System.out.println("Exception occured while moving towards to the element "+e.getMessage());
			}
		}
	}
	public boolean DoesElementExist(String xpath) {
		WebDriverWait wait 			=	new WebDriverWait(driver,Duration.ofSeconds(10));
		boolean flagvalue			=	false;
		try {
			WebElement flag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			if(flag.isDisplayed()) {
				flagvalue			=	true;
			}else {
				flagvalue			=	false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flagvalue;
	}
	public boolean WaitForPageToLoad(String locator) {
		boolean flag			=	false;
		for(int i=0;;i++) {
			if(i>10) {
				break;
			}
			try {
				if(waitForElement(locator)) {
					flag		=	true;
					break;
				}
			}catch(Exception e) {
				flag			=	false;
			}
		}
		return flag;
	}
	public boolean waitForElement(String element) {
		try {
			WebDriverWait wait		=	new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement we			=	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
			if(we!=null) {
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			System.out.println("waitForElement Exception occured "+e.getMessage());
			return false;
		}
	}
	
	public boolean verifyElementPresentAndClearEnterText(String xpath,String name){
		boolean  flag		= 	false;
		try {
			if(DoesElementExist(xpath)) {
				driver.findElement(By.xpath(xpath)).clear();
				driver.findElement(By.xpath(xpath)).sendKeys(name);
				driver.findElement(By.xpath("(//span[@class='ng-star-inserted'])[1]")).click();
				flag		=	true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
}
