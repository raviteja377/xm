import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustry {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver","F:\\selinium jar files folder\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
        driver.findElement(By.id("submitButton")).click();
        driver.findElement(By.linkText("Organizations")).click();
       driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
        driver.findElement(By.name("accountname")).sendKeys("vz1");
        WebElement ele = driver.findElement(By.name("industry"));
        Select ddp=new Select(ele);
        ddp.selectByValue("Healthcare");
       
        WebElement sav = driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]"));
        sav.click();
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
    	Actions act=new Actions(driver);
    	act.moveToElement(element).perform();

    	act.moveToElement(driver.findElement(By.xpath("//a[text()='Sign Out']"))).click().perform();
    	driver.close();

	}

}
