package testng.tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class firstTest {

	@BeforeTest

	public void bTest() {
		System.out.println("I am in before Test");
	}
	@AfterTest

	public void ATest() {
		System.out.println("I am in after Test");
	}
	@BeforeMethod(alwaysRun = true)

	public void bMethod() {
		System.out.println("I am in before Method");
	}
	@AfterMethod(alwaysRun = true)

	public void AMethod() {
		System.out.println("I am in after Method");
	}
	@Test(groups= {"smoke"})
	public void add() {
		System.out.println("I am in method 'sadd'");
		
	}
	@Test(dependsOnGroups= {"smoke"},alwaysRun=true)
	public void update() {
		System.out.println("I am in method 'update'");
		
	}
	@Test
	public void delete() {
		System.out.println("I am in method 'delete'");
		
	}
	@Test
	public void filter() {
		System.out.println("I am in method 'filter'");
		
	}
	
	@Test
	public void webLogin() {
		System.out.println("I am in method 'webLogin'");
		
	}
	
	@Test
	public void webAdd() {
		System.out.println("I am in method 'webAdd'");
		
	}
	@Test
	public void webFilter() {
		System.out.println("I am in method 'webFilter'");
		
	}
}
