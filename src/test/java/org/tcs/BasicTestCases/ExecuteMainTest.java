package org.tcs.BasicTestCases;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.tcs.selenium.LanuchBrower.Utilities.PropertiesLoad;
import org.testng.TestNG;


public class ExecuteMainTest {
	public static void main(String args[]) {
		try {
			System.out.println("Execution of Main Test has stated..");
			TestNG testNg					=	new TestNG();
			PropertiesLoad util				=	new PropertiesLoad();
			List<String> list				=	new ArrayList<String>();
			String PropertyName				=	"Prod";
			
			util.loadProperties(PropertyName);
			
			String HomeDir					=	util.getCurrentWorkingDir();
			list.add(HomeDir+File.separator+"testng.xml");
			
			testNg.setTestSuites(list);
			testNg.run();
			System.out.println("Execution of Main Test has closed..");
		}catch(Exception e) {
			System.out.println("Exception occured.... "+e.getMessage());
			e.printStackTrace();
		}
	}
}
