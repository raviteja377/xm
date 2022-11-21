import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContact {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","F:\\selinium jar files folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
        driver.findElement(By.name("lastname")).sendKeys("abc");
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        
       WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(element)

	.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().perform();
	driver.quit();
	}

}
