import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","F:\\selinium jar files folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        //navigatae to organizations 
        driver.findElement(By.linkText("Organizations")).click();
        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
         driver.findElement(By.name("accountname")).sendKeys("xy1");
       
         driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
         //navigate to contacts
         Thread.sleep(2000);
        driver.findElement(By.linkText("Contacts")).click();
        driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
        driver.findElement(By.name("lastname")).sendKeys("abc");
    
        driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt='Select']")).click();
        
String parent = driver.getWindowHandle();
Set<String> child = driver.getWindowHandles();
for(String childs:child) {
	if(!parent.equalsIgnoreCase(childs)) {
		driver.switchTo().window(childs);
		WebElement sea = driver.findElement(By.id("search_txt"));
		sea.sendKeys("xy1");
		sea.submit();
		driver.findElement(By.linkText("xy1")).click();
		
	}
}
driver.switchTo().window(parent);
driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
Actions act=new Actions(driver);
act.moveToElement(element)

.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().perform();
driver.close();

	}

}
