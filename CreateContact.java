package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Stefi");
		driver.findElement(By.id("lastNameField")).sendKeys("Z");
		driver.findElement(By.name("departmentName")).sendKeys("EC");
		driver.findElement(By.id("createContactForm_description")).sendKeys("my contact");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("stefigrace@gmail.com");
		
		WebElement eleState = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dropDownState = new Select(eleState);
		dropDownState.selectByVisibleText("New York");
		
		driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
		String strTitle = driver.getTitle();
		System.out.println(driver.getTitle());
		
		if (strTitle.equals("View Contact | opentaps CRM")){
			driver.findElement(By.linkText("Edit")).click();
			String strTitleEdit = driver.getTitle();
			System.out.println(driver.getTitle());
			if (strTitleEdit.equals("opentaps CRM")) {
				driver.findElement(By.id("updateContactForm_description")).clear();
				driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("important text");
				driver.findElement(By.xpath("//input[@type='submit']")).click();
			}
			else {
				System.out.println("Error");
			}
		}
		else {
			System.out.println("Error");
		}
		
		
		System.out.println(driver.getTitle());
		
		driver.close();	
		
}
}
