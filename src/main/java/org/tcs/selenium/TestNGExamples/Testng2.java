package org.tcs.selenium.TestNGExamples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class Testng2 {
	@DataProvider(name="data")
	public Object[][] getData(){
		Object[][] data	= new Object[1][2];
		data[0][0]= "venkateshBabu";
		data[0][1]= "venky123";
		
		
		return data;
		 
	}
	
	@Test(groups="venky12",dataProvider="data")
	public void helo1(String name,String pass) {
		System.out.println(name+" 1 "+pass);
	}
	@Test(groups="venky12",dataProvider="data")
	public void helo2(String name,String pass) {
		int a=10;int b=0;
		int c=a/b;
		System.out.println(name+" 2 "+pass);
	}
	@Test(groups="venky12",dataProvider="data")
	public void helo3(String name,String pass) {
		System.out.println(name+" 3 "+pass);
	}
	
	
}
