package testng.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
	
	@Test
	public void method1() {
		SoftAssert sc=new SoftAssert();
		int a=3;
		int b=5;
		sc.assertEquals(a, b);
		System.out.println("end");
	
		sc.assertAll();
	}

}
