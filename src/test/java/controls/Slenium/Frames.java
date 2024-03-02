package controls.Slenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize(); 
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("a[href='/frames']")).click();
		driver.findElement(By.cssSelector("a[href='/nested_frames']")).click();
		
		driver.switchTo().frame(0);//top frame
		Thread.sleep(1000);
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-left']")));//left frame which is inside top frame
		String name=driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
		System.out.println(name);
		driver.switchTo().defaultContent();//come out from left frame
		
		
		driver.switchTo().frame("frame-top");
		Thread.sleep(1000);
		driver.switchTo().frame("frame-right");
		String name1=driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]")).getText();
		System.out.println(name1);
		driver.navigate().back();
		
		driver.findElement(By.cssSelector("a[href='/iframe']")).click();
		driver.close();
		
		
		
	}

}
