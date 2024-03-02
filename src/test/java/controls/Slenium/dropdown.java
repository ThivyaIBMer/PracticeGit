package controls.Slenium;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown {
	static WebDriver driver = null;
	public void staticDropDown() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize(); 
		//Thread.sleep(1000);
//		WebDriverWait wait=new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/dropdown']")));
		driver.findElement(By.cssSelector("a[href='/dropdown']")).click(); 
		
		@SuppressWarnings({ "unchecked", "deprecation", "rawtypes" })
		Wait wait1 =new FluentWait(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(10)).ignoring(NoSuchElementException.class);
		
		
				@SuppressWarnings("unchecked")
				WebElement w=(WebElement) wait1.until(new Function<WebDriver,WebElement>(){
					

					@Override
					public WebElement apply(WebDriver t) {
						// TODO Auto-generated method stub
						return driver.findElement(By.cssSelector("#test"));
					}

					
					
					
				});
				
						
						
						
						
						
						
						
				
		WebElement dropdown=driver.findElement(By.cssSelector("select[id='dropdown']")); 
		Select dropdown_values=new Select(dropdown); 
		dropdown_values.selectByIndex(1);
		Thread.sleep(1000); 
		dropdown_values.selectByIndex(2); 
		Thread.sleep(1000);
		//System.out.println(dropdown_values.getFirstSelectedOption().getText());
		dropdown_values.selectByValue("2"); 
		Thread.sleep(1000);
		dropdown_values.selectByValue("1");
		Thread.sleep(1000);
		//System.out.println(dropdown_values.getFirstSelectedOption().getText());
		dropdown_values.selectByVisibleText("Option 2");
		Thread.sleep(1000);
		//System.out.println(dropdown_values.getFirstSelectedOption().getText());
		
		List<WebElement> dd=dropdown_values.getOptions();
		for(int i=0;i<dd.size();i++) {
			System.out.println(dd.get(i).getText());
		}
		}
	
	public void scrollDD() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize(); 
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div#select-class-example #autosuggest")).sendKeys("me");//method1 to send value
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.querySelector(\"div#select-class-example #autosuggest\").value='me';");////method2 to send value
//		Thread.sleep(3000);
//		WebElement webElement1 = driver.findElement(By.xpath("//div[@id='select-class-example']//*[@id='autosuggest']"));//method3 to send value
//		((JavascriptExecutor)driver).executeScript("arguments[0].value='me';", webElement1);
//		Thread.sleep(3000);
		/*1st Method
		 * List<WebElement> dd=driver.findElements(By.cssSelector("ul#ui-id-1 li a"));
		 * 
		 * for(WebElement country:dd) { if(country.getText().equals("Suriname")) {
		 * country.click();
		 * 
		 * break; } }
		 */
		/* 2nd Method
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("document.querySelector(\"#ui-id-1\").scrollTop=3000");
		 * 
		 * 
		 * driver.findElement(By.xpath("//a[text()='Suriname']")).click();
		 * Thread.sleep(3000);
		 */
		Thread.sleep(3000);
		WebElement webElement = driver.findElement(By.xpath("//a[text()='Suriname']"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webElement);
		webElement.click();
		
	}
	public void dynamicDD() throws InterruptedException {
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize(); 
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div[data-testid='to-testID-origin'] input[autocapitalize='sentences']")).sendKeys("Chennai");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[data-testid='to-testID-destination'] input[autocapitalize='sentences']")).clear();
		driver.findElement(By.cssSelector("div[data-testid='to-testID-destination'] input[autocapitalize='sentences']")).sendKeys("Banglore");
		Thread.sleep(2000);
	}
	public void autoComplete() throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		String exp="test";
		if(	driver.getTitle().equals(exp)) {
			System.out.println("it is passed");
		}
		driver.getTitle();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("input[id='autosuggest']")).sendKeys("ind");
		Thread.sleep(2000);
		List<WebElement> countries=driver.findElements(By.cssSelector("ul[class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all'] li a"));
		
		for(WebElement dpt:countries) {
			System.out.println(countries);
			if(dpt.getText().equalsIgnoreCase("india")) {
				dpt.click();
				break;
				
				
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		dropdown d=new dropdown();
		d.scrollDD();
		//d.staticDropDown();
//		d.dynamicDD();
//		d.autoComplete();
Thread.sleep(2000);



		driver.close();
	}

}
