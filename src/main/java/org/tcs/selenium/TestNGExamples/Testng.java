package org.tcs.selenium.TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testng {
	@Test(groups="venky",enabled=false)
	public void method1() {
		System.out.println("Method 1");
	}
	@Test(groups="venky",enabled=false)
	public void method2() {
		System.out.println("Method 2");
	}
	@Parameters({"username","password"})
	@Test(groups="venky1")
	public void method3(String User,String Pass) {
		System.out.println("MY name is :"+User+" and my password is :"+Pass);
	}
	@Test(groups="venky")
	public void sample() {
		System.out.println("sample");
	}
}
