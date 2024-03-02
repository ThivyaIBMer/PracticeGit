package controls.Slenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandling {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		
		//Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href*='windows']")).click();

		driver.findElement(By.cssSelector("a[href*='windows']")).click();
		//Thread.sleep(1000);
		boolean t=driver.findElement(By.cssSelector("div>h3")).isDisplayed();
		System.out.println(t);

		String parent=driver.getWindowHandle();
		Set<String> child=driver.getWindowHandles();

		Iterator<String> it=child.iterator();
		while(it.hasNext()) {
			String child_window=it.next();
			if(!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				String st=driver.findElement(By.cssSelector("div>h3")).getText();
				System.out.println(st);
				driver.quit();
			}
		}

		driver.switchTo().window(parent);
		String st1=driver.findElement(By.cssSelector("div>h3")).getText();
		System.out.println(st1);

	}

}
