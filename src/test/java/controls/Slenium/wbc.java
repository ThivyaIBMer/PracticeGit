package controls.Slenium;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class wbc {
	static WebDriver driver = null;
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize(); 
		Thread.sleep(2000);
		List<WebElement> footer=driver.findElements(By.cssSelector("#gf-BIG tr td ul li a"));
		for (WebElement ele : footer) {
			Actions act=new Actions(driver);
			act.moveToElement(ele).keyDown(Keys.CONTROL);
			act.click().keyUp(Keys.CONTROL).build().perform();
		}
		String parent=driver.getWindowHandle();

		Set<String>s=driver.getWindowHandles();


		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{

			String child_window=I1.next();


			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();}
		}
		driver.switchTo().window(parent);
		driver.close();
	}

}
