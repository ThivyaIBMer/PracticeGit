package controls.Slenium;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sorting {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='username']")));
		driver.findElement(By.cssSelector("[name='username']")).sendKeys("Admin");
		driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin123");
		driver.findElement(By.cssSelector("[type='submit']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
		Assert.assertEquals("OrangeHRM",driver.getTitle());
		driver.findElement(By.cssSelector("[href*='admin']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Username']/child::div/child::i")));

		List<WebElement> original=driver.findElements(By.cssSelector("div.oxd-table-card div.oxd-table-row.oxd-table-row--with-border div[role='cell']:nth-child(2)"));
		
		List<String> original_list=original.stream().map(t->t.getText()).collect(Collectors.toList());
		//List<String> originalsorted=original_list.stream().sorted().collect(Collectors.toList());
		Collections.reverse(original_list);
		
		
		driver.findElement(By.xpath("//div[text()='Username']/child::div/child::i")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Username']/child::div/child::div//span[text()='Descending']")));
		driver.findElement(By.xpath("//div[text()='Username']/child::div/child::div//span[text()='Descending']")).click();
		Thread.sleep(2000);
		
		List<WebElement> actual=driver.findElements(By.cssSelector("div.oxd-table-card div.oxd-table-row.oxd-table-row--with-border div[role='cell']:nth-child(2)"));
		
		List<String> actual_list=actual.stream().map(t->t.getText()).collect(Collectors.toList());
		
		System.out.println(original_list);
		System.out.println(actual_list);
		boolean f=original_list.equals(actual_list);
		System.out.println(f);

	}

}
