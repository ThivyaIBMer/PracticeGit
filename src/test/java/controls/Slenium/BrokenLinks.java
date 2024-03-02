package controls.Slenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	
	static WebDriver driver = null;
	private static int getResponseCode(WebElement y) throws MalformedURLException, IOException {
		
		String url=y.getAttribute("href");
		HttpURLConnection con=(HttpURLConnection) new URL(url).openConnection();
		con.setRequestMethod("HEAD");
		con.connect();
		int respCode=con.getResponseCode(); 
		if(respCode>400) {
			System.out.println(y.getText());
		}

		return respCode;


	}
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize(); 
		Thread.sleep(2000);
		List<WebElement> footer=driver.findElements(By.cssSelector("#gf-BIG tr td ul li a"));

		footer.stream().map(s->{
			try {
				return getResponseCode(s);
			} catch (Exception e) {
				System.out.println(e);
			} 
			return null;
		}).collect(Collectors.toList());

	}

}
