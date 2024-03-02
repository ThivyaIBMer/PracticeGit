package controls.Slenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class scrolling {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("a[href*='infinite']")).click(); 
		Thread.sleep(2000);
	/*	//Vertical scrolling downwards
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		//vertical scrolling upwards
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,-1000)");
		Thread.sleep(2000);
		//Horizontal scrolling rightwards
		((JavascriptExecutor)driver).executeScript("window.scrollBy(100,0)");
		//Horizontal scrolling leftwards
		((JavascriptExecutor)driver).executeScript("window.scrollBy(-100,0)");
		Thread.sleep(2000);*/
		/*((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);*/ //method2
		
		/*method3
		 * Actions action=new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		driver.navigate().back();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);*/
		
		
		driver.close();


	}

}
