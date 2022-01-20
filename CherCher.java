package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCher {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.switchTo().frame("frame1");
		
		WebElement element = driver.findElement(By.xpath("//b[@id='topic']/following-sibling::input"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		element.sendKeys("Test");
		
		driver.switchTo().frame("frame3");
		
		driver.findElement(By.xpath("//input[@id='a' and @type='checkbox']")).click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		
		
		WebElement animals = driver.findElement(By.id("animals"));
		Select drop = new Select(animals);
		drop.selectByVisibleText("Baby Cat");
		driver.switchTo().defaultContent();
		
		driver.close();
	}

}
