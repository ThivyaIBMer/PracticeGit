package controls.Slenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Filtering {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://candid-travesseiro-6205c0.netlify.app/");
		driver.manage().window().maximize(); 
		Thread.sleep(2000);
		driver.findElement(By.id(":r0:")).sendKeys("member");
		
		Thread.sleep(2000);
		int count=driver.findElements(By.cssSelector("div.pagination button")).size();
		for(int i=0;i<count-2;i++) {
			List<WebElement> original1=driver.findElements(By.cssSelector("table[id='users'] tbody tr[class='rowItems'] td:nth-child(4)"));
			original1.get(i).getText().equalsIgnoreCase("member");
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='>']")));
		}
		
	
		
	}

}
