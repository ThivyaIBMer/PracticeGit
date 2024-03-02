package controls.Slenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calendar {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//		driver.manage().window().maximize();
//		driver.findElement(By.cssSelector("input#ctl00_mainContent_view_date1~button.ui-datepicker-trigger")).click();
//		Thread.sleep(1000);
		//To choose current date
		/*
		 * String
		 * expectedClassName="ui-state-default ui-state-highlight ui-state-hover";
		 * String actualName=""; List<WebElement> classCalendar=driver.findElements(By.
		 * cssSelector("table.ui-datepicker-calendar tr a")); for (WebElement ele :
		 * classCalendar) { actualName=ele.getAttribute("class");
		 * if(expectedClassName.equals(actualName)) { ele.click(); break; } }
		 */
		//To choose expected date along with expected month
		/*
		 * driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e")).
		 * click(); List<WebElement> dateValues=driver.findElements(By.
		 * cssSelector("table.ui-datepicker-calendar tbody tr td[data-month='2'] a"));
		 * 
		 * for (WebElement webElement : dateValues) {
		 * if(webElement.getText().equals("24")) { webElement.click(); break; }
		 * 
		 * }
		 */
		//driver.quit();
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//To choose year in a calendar
		driver.get("https://www.calculator.net/age-calculator.html");
		String dob="12 March 1993";
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#today_ID_Link")).click();
		Thread.sleep(2000);
		String actualYear=driver.findElement(By.cssSelector("#today_Current_ID")).getText();
		System.out.println(actualYear);
		String[] splitYear=actualYear.split(" ");
		int currentYear=Integer.parseInt(splitYear[1]);
		int expYear=1993;
		int count=currentYear-expYear;
		int i=0;
		while(i<count*12) {
			driver.findElement(By.id("today_Previous_ID")).click();
			i++;
			
		}
		Thread.sleep(4000);
		String[] months= {"January","February","March"};
		String[] dobSplit=dob.split(" ");
		String actualMonth=dobSplit[1];
		int j=0;
		for (int k=0;k<months.length;k++) {
			j++;
			if(months[k].equals(actualMonth)){
				break;
			}
		}
		System.out.println(j);
		int l=0;
		while(l<j-1) {
			driver.findElement(By.id("today_Next_ID")).click();
			l++;
		}
		driver.findElement(By.xpath("//td[text()='25']")).click();
		System.out.println("year chosen");
	}

}
