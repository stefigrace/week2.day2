package week2.day2;

import java.awt.List;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		
		driver.findElement(By.xpath("//button[text() ='Find Leads']")).click();
		driver.findElement(By.xpath("//div[@class='x-tab-strip-wrap']//li[2]")).click();
		
		driver.findElement(By.name("phoneAreaCode")).sendKeys("044");
		driver.findElement(By.name("phoneNumber")).sendKeys("8754422035");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(2000);
		String strLeadId = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).getText();
		System.out.println(strLeadId); 
		
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.linkText("Delete")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//a[text() ='Find Leads']")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(strLeadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String strMsg = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
		System.out.println(strMsg);
		
		driver.close();			

	}

}
