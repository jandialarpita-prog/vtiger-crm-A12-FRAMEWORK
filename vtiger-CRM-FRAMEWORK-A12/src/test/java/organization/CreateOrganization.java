package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganization {
public static void main(String[] args) throws InterruptedException {
		
		//OPEN BROWSER
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		//LOGIN
		driver.get("http://localhost:8888/index.php?action=index&module=Home");
		
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("manager");
		
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);
		
		//CREATE ORGANIZATION
		driver.findElement(By.linkText("Organizations")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
		//FILLING DATA TO THE FORM
		WebElement orgField = driver.findElement(By.name("accountname"));
		String orgName = "automationwitharpita";
		orgField.sendKeys(orgName);
		
		Thread.sleep(2000);
		
		WebElement phoneNumber = driver.findElement(By.id("phone"));
		phoneNumber.sendKeys("9834751880");
		
		Thread.sleep(2000);
		
		WebElement mail = driver.findElement(By.id("email1"));
		mail.sendKeys("arpitagupta@gmail.com");
		Thread.sleep(2000);
		
		WebElement dropDown= driver.findElement(By.name("rating"));
		Select rating = new Select(dropDown);
		rating.selectByValue("Active");
		
        Thread.sleep(2000);
		
        WebElement webSite = driver.findElement(By.cssSelector("input[name='website']"));
		webSite.sendKeys("www.automationproject.in");
		
		Thread.sleep(2000);
		
        WebElement employ = driver.findElement(By.id("employees"));
		employ.sendKeys("45");
		
		Thread.sleep(2000);
		
		WebElement dropDown1= driver.findElement(By.name("industry"));
		Select industry = new Select(dropDown1);
		industry.selectByValue("Banking");
		
		Thread.sleep(2000);
		
		WebElement dropDown2= driver.findElement(By.name("accounttype"));
		Select accounttype = new Select(dropDown2);
		accounttype.selectByValue("Partner");
		
		Thread.sleep(2000);
		
		WebElement annualRevenue= driver.findElement(By.name("annual_revenue"));
		annualRevenue.sendKeys("6000000");
		
		Thread.sleep(2000);
		
		//SAVE
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
		//VERIFICATION
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		if(actOrgName .equals(orgName)) {
			System.out.println("Created Organization Successfully!!!!");
		}
		else {
			System.out.println("Failed......");
		}
		
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		
		act.moveToElement(profilePic).build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();
	}
	


}
