package week4.day1.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesSize {

	public static void main(String[] args) throws IOException {
		
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leafground.com/pages/frame.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Take the the screenshot of the click me button of first frame
		driver.switchTo().frame(0);
		WebElement click = driver.findElement(By.xpath("//button[text()='Click Me']"));
		File source = click.getScreenshotAs(OutputType.FILE);
		File dest = new File("./target/Images/frame.png");
		FileUtils.copyFile(source, dest);
		driver.switchTo().defaultContent();
		
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		int size = frames.size();
		System.out.println("Frame size: " + size);
		
		driver.close();
	}

}
