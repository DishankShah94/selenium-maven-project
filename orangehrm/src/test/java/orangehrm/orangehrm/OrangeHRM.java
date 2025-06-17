package orangehrm.orangehrm;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		String url = "https://www.google.com/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Username')]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[contains(@placeholder,'Password')]")).sendKeys("admin123");
		driver.findElement(By.cssSelector(".oxd-button.oxd-button--medium.oxd-button--main.orangehrm-login-button")).submit();
		System.out.println("user reached on dashboard");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".oxd-main-menu-item")).click();
		System.out.println("user navigated on Admin home page");
		Thread.sleep(2000);		
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")).click();
		Thread.sleep(2000);
		//User role
		driver.findElement(By.xpath("//label[text()='User Role']//following::div[4]")).click();
		driver.findElement(By.xpath("//label[text()='User Role']//following::span[1]")).click();
		Thread.sleep(2000);
		//employee name
		driver.findElement(By.xpath("//label[text()='Employee Name']//following::input[1]")).sendKeys("test");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[text()='Employee Name']//following::span")).click();
		//status
		driver.findElement(By.xpath("//label[text()='Status']//following::div[4]")).click();
		driver.findElement(By.xpath("//label[text()='Status']//following::span[1]")).click();
		//user name
		driver.findElement(By.xpath("//label[text()='Username']//following::input[1]")).sendKeys("Admin A");
		Thread.sleep(3000);
		//password
		driver.findElement(By.xpath("//label[text()='Password']//following::input[1]")).sendKeys("AdminMac@123");
		//confirm password
		driver.findElement(By.xpath("//label[text()='Confirm Password']//following::input[1]")).sendKeys("AdminMac@123");
	    //save 
		driver.findElement(By.xpath("//button[text()=' Save ']")).click();
		Thread.sleep(6000);
		// edit button
		List<WebElement> editButtons = driver.findElements(By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space'][2]"));
		Thread.sleep(6000);
		editButtons.get(1).click();
		Thread.sleep(6000);
		WebElement editUserName= driver.findElement(By.xpath("//label[text()='Username']//following::input[1]"));
		Thread.sleep(3000);
		editUserName.click();
		editUserName.clear();
		editUserName.sendKeys("Admin Ab");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(.,'Save')]")).click();
		Thread.sleep(8000);
		List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space'][1]"));
		deleteButtons.get(1).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
		Thread.sleep(5000);
		//logout
		driver.findElement(By.cssSelector(".oxd-userdropdown-tab")).click();
		driver.findElement(By.xpath("//a[contains(.,'Logout')]")).click();
		}
}
