package testng.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class thirdTests {

	@BeforeTest

	public void bTest() {
		System.out.println("I am in before Test3");
	}
	@AfterTest

	public void ATest() {
		System.out.println("I am in after Test3");
	}
	@BeforeMethod

	public void bMethod() {
		System.out.println("I am in before Method");
	}
	@AfterMethod

	public void AMethod() {
		System.out.println("I am in after Method");
	}
	@Test(groups={"smoke"})
	public void method3() {
		int a=1/0;
		System.out.println(a);
		System.out.println("I am in method3");

	}
}
