package org.tcs.SetUpSuite;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.tcs.selenium.LanuchBrower.Utilities.PropertiesLoad;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class SeleniumSetup {
	
	public static WebDriver driver			=	null;
	public static ExtentReports reports     =   null;
	public static ExtentTest test			=	null;
	
	
	@BeforeTest
	public void hello() {
		System.out.println("Hey where are you man i am berore test");
	}
	
	@BeforeSuite(enabled=false)
	public void launchBrowser(){
		
		try {
			PropertiesLoad 			SUtil	=	new  PropertiesLoad();
			HashMap<String,String> values   =   SUtil.properties;
			String Dir					    =	SUtil.getCurrentWorkingDir();
			String ReportFolderPath			=	FolderForReport();
		    reports 						=	new ExtentReports(ReportFolderPath+File.separator+"output.html",true);
			test 							=   reports.startTest("My First Test Case Creation");
			String name						= 	values.get("browser");
			System.out.println(name);
			if(name.equalsIgnoreCase("chrome")) {
				
				ChromeOptions options	=	new ChromeOptions();
				options.addArguments("--start-maximized");
				options.setExperimentalOption("excludeSwitches", List.of("disable-popup-blocking"));
				
				driver	=	new ChromeDriver(options);
				System.setProperty("webdriver.chrome.driver","C:\\Users\\venka\\Downloads\\chromedriver-win64\\chromedriver.exe");
				test.log(LogStatus.PASS, "Chrome Driver is launched");
				System.out.println("chrome driver launched");
			}else if(name.equalsIgnoreCase("edge")) {
				
				driver	=	new EdgeDriver();
				driver.manage().window().maximize();
				System.setProperty("webdriver.edge.driver","C:\\Users\\venka\\Downloads\\C:\\Users\\venka\\Downloads\\edgedriver_win64\\msedgedriver.exe");
				System.out.println("edge browser launched");
				test.log(LogStatus.PASS, "edge browser launched");
				System.out.println("Edge driver launched");

			}else if(name.equalsIgnoreCase("firefox")) {
				driver	=	new FirefoxDriver();
			}else {
				test.log(LogStatus.FAIL, "Unable to launch Driver");
				System.out.println("Unable to launch driver");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getDateandTime() {
		String formattedDate				=	null;
		try {
			LocalDateTime myDateObj 		= LocalDateTime.now();
		    DateTimeFormatter myFormatObj   = DateTimeFormatter.ofPattern("dd_MM_yyyy_HH_mm_ss");
	
		    formattedDate = myDateObj.format(myFormatObj);
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
		return formattedDate;
	}
	
	public static String FolderForReport() {
		String ReportFolderPath			=	null;
		PropertiesLoad 			SUtil	=	new  PropertiesLoad();
		String Dir   					=   SUtil.getCurrentWorkingDir();
		try {
			String DateandTime			=	getDateandTime();
			ReportFolderPath			=	Dir+File.separator+"Reports"+File.separator+"ReportFile_"+DateandTime;
			File 			file		=	new File(ReportFolderPath);
			file.mkdir();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ReportFolderPath;
	}
	
	
	@AfterSuite(enabled=false)
	public void tearDown() {
		test.log(LogStatus.PASS, "Driver is closed");
		reports.endTest(test);
		reports.flush();
		driver.quit();
		System.out.println("Browser has closed");
	}
}
