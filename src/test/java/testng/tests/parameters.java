package testng.tests;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameters {
	
	@Test
	@Parameters({"un","pwd"})
	public void Login(String user,String pass) {
		
		System.out.println("Username : "+user);
		System.out.println("Password :"+pass);
	}

}
