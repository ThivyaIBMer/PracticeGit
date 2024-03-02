package controls.Slenium;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://candid-travesseiro-6205c0.netlify.app/");
		driver.manage().window().maximize(); 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("//th[text()='Name']")));
	
		int listCount;
		do {
			List<WebElement> original=driver.findElements(By.cssSelector("table[id='users'] tbody tr[class='rowItems'] td:nth-child(2)"));
			List<WebElement> original_list=original.stream().filter(t->t.getText().contains("Colton Doe")).collect(Collectors.toList());
			System.out.println(original_list.size());
			Thread.sleep(3000);
			if(original_list.size()<1) {
				
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[text()='>']")));
			}
			listCount=original_list.size();

		}while(listCount<1);
		
		if(listCount==1) {
			driver.findElement(By.cssSelector("input[name='Colton Doe']")).click();
		}

	}

}
