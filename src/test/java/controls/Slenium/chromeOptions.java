package controls.Slenium;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chromeOptions {
	static WebDriver driver = null;
	public static void main(String[] args) {
		/*
		 * WebDriverManager.chromedriver().setup(); ChromeOptions options=new
		 * ChromeOptions(); options.addArguments("--incognito");
		 * options.addArguments("start-maximized"); Proxy p=new Proxy();
		 * p.setHttpProxy("ipAddresss:portNumber"); options.setCapability("proxy", p);
		 * //options.addArguments("headless");
		 * 
		 * options.setAcceptInsecureCerts(true);
		 * 
		 * 
		 * driver = new ChromeDriver(options); driver.get("https://expired.badssl.com");
		 */



		WebDriverManager.firefoxdriver().setup();


		FirefoxOptions profile = new FirefoxOptions(); 
		profile.addArguments("-private");
		driver = new FirefoxDriver(profile); 
		driver.get("https://expired.badssl.com");
	}

}
