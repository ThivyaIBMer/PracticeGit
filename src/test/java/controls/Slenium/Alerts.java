package controls.Slenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize(); 
		Thread.sleep(1000);
		/*driver.findElement(By.cssSelector("a[href*='alerts']")).click(); 
		driver.findElement(By.cssSelector("ul[style='list-style-type: none;'] button[onclick*='Alert']")).click(); 
		driver.switchTo().alert().accept();// to click ok btn
		driver.findElement(By.cssSelector("ul[style='list-style-type: none;'] button[onclick*='Confirm']")).click();
		driver.switchTo().alert().dismiss(); //to click cancel btn

		driver.findElement(By.cssSelector("button[onclick*='Prompt']")).click();
		Thread.sleep(1000);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("hello"); //to send values into alert
		driver.switchTo().alert().accept();*/
		
		
		driver.findElement(By.cssSelector("a[href*=basic_auth]")).click();
		driver.navigate().to("https:admin:admin@the-internet.herokuapp.com/");
		Thread.sleep(1000);
		driver.navigate().refresh();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		driver.navigate().forward();
		Thread.sleep(2000);
		
		
	}

}
