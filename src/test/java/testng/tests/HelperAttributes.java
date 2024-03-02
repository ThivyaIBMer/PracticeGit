package testng.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperAttributes {
	static WebDriver driver = null;
	@Test(dependsOnMethods = { "testTwo", "testThree" },alwaysRun=true)
	public void testOne() {
		System.out.println("Test method one");
	}
	@Test(invocationCount = 3)
	public void testinvo() {
		System.out.println("Repeat");
	}

	/*
	 * @Test(timeOut = 1000) public void testTwo() throws InterruptedException {
	 * System.out.println("Test method two");
	 * WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); //To
	 * choose year in a calendar
	 * driver.get("https://www.calculator.net/age-calculator.html");
	 * 
	 * driver.manage().window().maximize(); Thread.sleep(2000);
	 * 
	 * }
	 */

	@Test(enabled=true,description="TestmethodThree desc")
	public void testThree() {
		System.out.println("Test method three");
	}
	
	
	@Test(priority=1)
	public void login() {
		System.out.println("I am in login");

	}
	
	@Test(priority=2)
	public void create() {
		System.out.println("I am in create");

	}
	@Test
	public void update() {
		System.out.println("I am in update");

	}
	@Test(priority=-1)
	public void logoff() {
		System.out.println("I am in logoff");

	}
	//(expectedExceptions = ArithmeticException.class)
	@Test(expectedExceptions = ArithmeticException.class)
	public void sum() throws Exception {
		int a=1/0;
		//System.out.println(a);
		//throw new SkipException("ArithmeticException");
	}
	
	
	
	
	
}
