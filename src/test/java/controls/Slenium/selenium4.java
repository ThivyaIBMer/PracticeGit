package controls.Slenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;


public class selenium4 {
	static WebDriver driver = null;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		Actions act=new Actions(driver);
		act.click(driver.findElement(By.id("twotabsearchtextbox"))).keyDown(Keys.SHIFT).sendKeys("hello").keyUp(Keys.SHIFT);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize(); 
		//RelativeLocators
		WebElement ele=driver.findElement(By.cssSelector("input[name='name'][minlength='2']"));
		String value=driver.findElement(RelativeLocator.with(By.tagName("label")).above(ele)).getText();
		String value1=driver.findElement(RelativeLocator.with(By.tagName("label")).below(By.xpath("//label[text()='Name']"))).getText();
		System.out.println(value+"\n"+value1);
		String value2=driver.findElement(RelativeLocator.with(By.tagName("label")).toRightOf(By.cssSelector("input[id='exampleCheck1']"))).getText();
		String value3=driver.findElement(RelativeLocator.with(By.tagName("input")).toLeftOf(By.cssSelector("label[for='exampleCheck1']"))).getAttribute("type");
		System.out.println(value2+"\n"+value3);
		String value4=driver.findElement(RelativeLocator.with(By.tagName("input")).near(By.xpath("//h4[contains(text(),'Two-way Data Binding example:')]"))).getAttribute("class");
		System.out.println(value4+"\n");

		//getting height and width
		int h=ele.getRect().getDimension().getHeight();
		int w=ele.getRect().getDimension().getWidth();

		System.out.println("Height: "+h+"\n"+"Width:"+w);
		//full screenshot
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Output\\2.png"));
		//partial screenshot
		File f=ele.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(f, new File(System.getProperty("user.dir")+"\\Output\\3.png"));

		//new tab and window

		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.WINDOW);








	}

}
