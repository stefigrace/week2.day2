package week2.day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		
		driver.findElement(By.xpath("//div[@class='x-tab-strip-wrap']//li[2]")).click();
		driver.findElement(By.xpath("//div[@class='x-tab-strip-wrap']//li[3]")).click();
		
		driver.findElement(By.name("emailAddress")).sendKeys("stefigrace@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(2000);
		
		String strLeadName = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[1]")).getText();
		System.out.println(strLeadName); 
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		String strTitle = driver.getTitle();
		System.out.println(strTitle);
		
		if (strTitle.equalsIgnoreCase("Duplicate Lead | opentaps CRM")) {
			System.out.println("Title is matching");
			driver.findElement(By.name("submitButton")).click();
			String strName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
			System.out.println(strName);
		
			if(strName.equalsIgnoreCase(strName)) {
				System.out.println("duplicate lead name is matching");				
			} else {
				System.out.println("duplicate lead name is not matching");
			}
			
		}
		else {
			System.out.println("Title is not matching");			
		}	


	}
}
