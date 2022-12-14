package week7.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
			ChromeOptions ch=new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(ch);
		driver.get("https://www.leafground.com/waits.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   WebElement visible = driver.findElement(By.xpath("(//span[text()='Click'])[1]"));	        
		   visible.click();
	        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	        
	        wait.until(ExpectedConditions.visibilityOf(visible));
	        String text = driver.findElement(By.xpath("//span[text()='I am here']")).getText();
	        System.out.println(text);
	        if(text.contains("here"))
	        {
	        	System.out.println("The text HERE is appear");
	        	
	        }
	        else {
	        	System.out.println("The text HERE not appear");
	        }
	        
	      	        WebElement invisible = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt92']"));
	        invisible.click();
	        WebElement txt = driver.findElement(By.xpath("//span[text()='I am about to hide']"));
	        WebElement clickfirst = driver.findElement(By.xpath("//button[contains(@class,'ui-button-warning mr-6 mb-6')]"));
	        clickfirst.click();
	        wait.until(ExpectedConditions.visibilityOf(clickfirst));
	        driver.findElement(By.xpath("//button[@id='j_idt87:j_idt96']")).click();
	        String txt1= driver.findElement(By.xpath("//span[text()='I am going to change!']")).getText();
	        System.out.println(txt1);
	        WebElement data = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt98']"));
	        data.click();
	        WebElement textchange1 = driver.findElement(By.xpath("//span[text()='Did you notice?']"));
	        wait.until(ExpectedConditions.visibilityOf(textchange1));
	        String text1 = driver.findElement(By.xpath("//span[text()='Did you notice?']")).getText();
	        System.out.println("Changed to="+ text1);
	        driver.close();
	}

}
