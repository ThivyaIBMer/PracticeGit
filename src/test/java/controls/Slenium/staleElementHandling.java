package controls.Slenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class staleElementHandling {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://google.com");
		  //Locate the search text box
		  WebElement ele = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
		  //Refresh the web page
		  driver.navigate().refresh();
		  
		  try {
		  //Pass string using sendkeys to the web element
		  ele.sendKeys("Testing String");
		  }
		  catch(Exception e) {
			  WebElement elem = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
			  elem.sendKeys("Testing String from catch block");
			  //Fetching the string entered in the search text box
			  String str = elem.getAttribute("value");
			  System.out.println("The string entered from catch block is - " +str);
		  }
		  
		  driver.quit();
		  WebElement elem = driver.findElement(By.xpath("//textarea[@class=\"gLFyf\"]"));
		  elem.sendKeys("Testing String from catch block");
	}

}