package testng.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Logging {

	static WebDriver driver = null;
	static  Logger log=Logger.getLogger(Logging.class);
//	log.warn("It is a warning");
//	log.fatal("It is a fatal");
//	log.error("It is a error");
//	log.trace("trace");
//	log.debug("debug");
	@Test
	public void test() throws InterruptedException {
	
	WebDriverManager.chromedriver().setup();
	log.info("********************Test case started************************");
	log.info("Launch chrome browser");
	driver = new ChromeDriver();
	log.info("Navigate to URL");
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	log.info("Give username");
	Thread.sleep(3000);
	driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
	log.info("Give Password");
	driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
	log.info("Click Submit button");
	driver.findElement(By.cssSelector("button[type='submit']")).click();
	Thread.sleep(3000);
	String pageTitle=driver.getTitle();
	
		if(pageTitle.equals("test")) {
			log.fatal("expected page title displayed");
		}
	
		else {
		log.fatal("expected page title not displayed");
		}
	
	
	
	
	
	
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	log.info("********************Test case ended************************");
	}
}
