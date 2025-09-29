package troubletickets;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Create_TROUBLE_TICKETS {
	public static void main(String[] args) throws InterruptedException {
		// OPEN BROWSER
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// LOGIN
		driver.get("http://localhost:8888");

		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");

		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("manager");

		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(2000);

		// CREATE TROUBLE TICKETS
		driver.findElement(By.linkText("Trouble Tickets")).click();

		Thread.sleep(2000);

		driver.findElement(By.cssSelector("img[alt='Create Ticket...']")).click();

		// FILLING DATA TO THE FORM
		WebElement orgField = driver.findElement(By.name("ticket_title"));
		String orgName = "Automation With Arpita";
		orgField.sendKeys(orgName);

		Thread.sleep(2000);

		WebElement dropDown = driver.findElement(By.name("parent_type"));
		Select parent_type = new Select(dropDown);
		parent_type.selectByValue("Accounts");

		// USING WINDOW HANDLE FIRST TIME

		// STEP 1:GET THE HOME ADDRESS/PARENT ID
		String PID = driver.getWindowHandle();

		// STEP 2 :PERFORM THE TASK WHICH WILL OPEN NEW WINDOW
		driver.findElement(By.xpath("//tr[3]//img[@alt='Select']")).click();

		// STEP 3 :GET ALL THE WINDOWS ID/CJILDERN IDS
		Set<String> IDS = driver.getWindowHandles();

		// STEP 4 :SWITCH TO PARTICULAR WINDOW
		for (String i : IDS) {
			driver.switchTo().window(i);

			// STEP 5 :PERFORM THE TASK
			if (driver.getCurrentUrl().contains("Popup_picker")) {
				WebElement choose = driver.findElement(By.linkText("automationwitharpita"));
				Actions act = new Actions(driver);
				act.moveToElement(choose).click().build().perform();
				Thread.sleep(1000);
				driver.close();
				break;
			}
		}

		// STEP 6 :COME BACK TO HOME/PARENT PAGE
		driver.switchTo().window(PID);
		Thread.sleep(1000);
		
		/*
		WebElement productName = driver.findElement(By.name("product_name"));

		// USING WINDOW HANDLE SECOND TIME

		// STEP 1:GET THE HOME ADDRESS/PARENT ID
		String PID2 = driver.getWindowHandle();

		// STEP 2 :PERFORM THE TASK WHICH WILL OPEN NEW WINDOW
		driver.findElement(By.xpath("//tr[4]//img[@alt='Select']")).click();

		// STEP 3 :GET ALL THE WINDOWS ID/CJILDERN IDS
		Set<String> IDS2 = driver.getWindowHandles();

		// STEP 4 :SWITCH TO PARTICULAR WINDOW
		for (String j : IDS2) {
			driver.switchTo().window(j);

			// STEP 5 :PERFORM THE TASK
			if (driver.getCurrentUrl().contains("Popup_picker")) {
				WebElement choose2 = driver.findElement(By.linkText("abcd1234"));
				Actions act = new Actions(driver);
				act.moveToElement(choose2).click().build().perform();
				Thread.sleep(1000);
				driver.close();
				break;
			}
		}

		// STEP 6 :COME BACK TO HOME/PARENT PAGE
		driver.switchTo().window(PID2);
		Thread.sleep(3000);
        */
		
		WebElement dropDown1 = driver.findElement(By.name("ticketpriorities"));
		Select ticketpriorities = new Select(dropDown1);
		ticketpriorities.selectByValue("Normal");

		Thread.sleep(2000);

		WebElement dropDown2 = driver.findElement(By.name("ticketseverities"));
		Select ticketseverities = new Select(dropDown2);
		ticketseverities.selectByValue("Critical");

		Thread.sleep(2000);

		WebElement dropDown3 = driver.findElement(By.name("ticketcategories"));
		Select ticketcategories = new Select(dropDown3);
		ticketcategories.selectByValue("Small Problem");

		Thread.sleep(2000);

		WebElement dropDown4 = driver.findElement(By.name("ticketstatus"));
		Select ticketstatus = new Select(dropDown4);
		ticketstatus.selectByValue("In Progress");

		Thread.sleep(2000);

		WebElement ticket_no = driver.findElement(By.id("ticket_no"));
		ticket_no.sendKeys("AUTO GEN ON SAVE");

		Thread.sleep(2000);

		// SAVE
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();

		// VERIFICATION
		String actOrgName = driver.findElement(By.id("dtlview_Title")).getText();

		if (actOrgName.equals(orgName)) {
			System.out.println("Created Trouble Tickets Successfully!!!!");
		} else {
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
