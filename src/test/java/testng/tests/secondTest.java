package testng.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class secondTest {
	
	@BeforeSuite

	public void bSuite() {
		System.out.println("I am in before Suite");
	}
	@AfterSuite

	public void ASuite() {
		System.out.println("I am in after Suite");
	}
	@BeforeTest

	public void bTest() {
		System.out.println("I am in before Test");
	}
	@AfterTest()

	public void ATest() {
		System.out.println("I am in after Test");
	}
	@Test(groups= {"Regression"})
	public void method2() {
		System.out.println("I am in method2");
		
	}
	
	@BeforeClass

	public void bClass() {
		System.out.println("I am in before Class2");
	}
	@AfterClass

	public void AClass() {
		System.out.println("I am in after Class2");
	}
	@BeforeMethod

	public void bMethod() {
		System.out.println("I am in before Method");
	}
	@AfterMethod

	public void AMethod() {
		System.out.println("I am in after Method");
	}

}
