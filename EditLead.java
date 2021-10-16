package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@id='x-form-el-ext-gen248']/input[1]")).sendKeys("Stefi");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String strTitle = driver.getTitle();
		System.out.println(strTitle);

		if (strTitle.equalsIgnoreCase("View Lead | opentaps CRM")) {
			System.out.println("Title is same");
			driver.findElement(By.linkText("Edit")).click();
			driver.findElement(By.id("updateLeadForm_companyName")).clear();
			driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("HCL");
			driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();

			Thread.sleep(2000);

			String strCompanyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
			System.out.println(strCompanyName);
			if (strCompanyName.equalsIgnoreCase("hcl")) {
				System.out.println("Company name updated");
			} else {
				System.out.println("Company name is not updated");
			}
		} else {
			System.out.println("Title is not same");
		}

		driver.close();

	}

}
