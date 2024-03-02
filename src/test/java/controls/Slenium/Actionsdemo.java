package controls.Slenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actionsdemo {
	static WebDriver driver = null;
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize(); 
		driver.findElement(By.cssSelector("a[href*='drag']")).click();
		Actions act1=new Actions(driver);
		act1.dragAndDrop(driver.findElement(By.id("column-a")),driver.findElement(By.id("column-b"))).build().perform();
		Thread.sleep(10000);
		
//		driver.get("https://www.amazon.in");
//		driver.manage().window().maximize();
//		Thread.sleep(1000);
//		Actions act=new Actions(driver);
//		act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT);
//		act.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).sendKeys(Keys.ENTER);
//		driver.navigate().back();
//		
//		WebElement ele=driver.findElement(By.xpath("//span[text()='Account & Lists']"));
//		act.moveToElement(ele).build().perform();
//		Thread.sleep(1000);
//		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Output\\1.png"));
//		
//		act.doubleClick(driver.findElement(By.xpath("//div[text()='Your Account']"))).build().perform();
//		Thread.sleep(1000);
//		act.contextClick(driver.findElement(By.xpath("//div[text()='Your Account']"))).build().perform();
//		Thread.sleep(5000);
//		driver.close();
//		
		
		
	
	}

}
