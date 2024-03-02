package controls.Slenium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploading {
	static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		String path=System.getProperty("user.dir")+"\\downloads";
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", path);
		ChromeOptions options=new ChromeOptions();

		options.setExperimentalOption("prefs", chromePrefs);

		driver = new ChromeDriver(options);

		driver.get("https://altoconvertpdftojpg.com/");
		driver.manage().window().maximize(); 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("browse")));
		driver.findElement(By.id("browse")).click(); 
		Thread.sleep(5000);
		Runtime.getRuntime().exec("D:\\SeleniumClass\\Slenium\\fileupload.exe");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#submit_btn")));
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#submit_btn")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Your files are converted!']")));
		driver.findElement(By.cssSelector("a[href*='/download']")).click();
		Thread.sleep(4000);
		File checkFile=new File(path+"\\invipdf.jpg");
		if(checkFile.exists()) {
			System.out.println("file found");
			
			if(checkFile.delete()) {
				System.out.println("file deleted");
			}
			else {
				System.out.println("File not deleted");
			}

		}
		else {
			System.out.println("File not found");
		}




		//	driver.findElement(By.cssSelector("#file-upload")).sendKeys("C:\\Users\\ADMIN\\Downloads\\Reception invite2.png");
		//driver.findElement(By.id("file-submit")).click();


	}

}
