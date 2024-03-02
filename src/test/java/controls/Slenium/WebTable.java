package controls.Slenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class WebTable {
	static WebDriver driver = null;
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		String headerWebTable=driver.findElement(By.xpath("//legend[text()='Web Table Fixed header']")).getText();
		Assert.assertEquals(headerWebTable, "Web Table Fixed header");
		Thread.sleep(1000);
		List<WebElement> trow=driver.findElements(By.cssSelector("div.tableFixHead #product tbody tr"));
		for(int i=1;i<trow.size();i++) {
			String cssformat=String.format("div.tableFixHead #product tbody tr:nth-child(%s) td", i);
			List<WebElement> tcol=driver.findElements(By.cssSelector(cssformat));
			for(int j=0;j<tcol.size();j++) {
				System.out.print(tcol.get(j).getText());
				System.out.print("\t");
			}
			System.out.print("\n");
		}
		
		List<WebElement> lastColumn=driver.findElements(By.cssSelector("div.tableFixHead #product tbody td:last-of-type"));
		
		int sum=0;
		for(int i=0;i<lastColumn.size();i++) {
			
			sum=sum+ Integer.parseInt(lastColumn.get(i).getText());
		}
		
		System.out.println(sum);
		System.out.println(driver.findElement(By.xpath("//a[text()='Social Media']")).getText());
		Assert.assertEquals(Integer.parseInt(driver.findElement(By.cssSelector("div.totalAmount")).getText().split(":")[1].trim()),sum);
	driver.quit();
	}

}
