import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExpliciteWaitPractice {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\SELENIUM\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait w = new WebDriverWait(driver, 5);
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");
		driver.findElement(By.xpath("//input[@id ='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("learning");
		List<WebElement> buttons = driver.findElements(By.xpath("//input[@id ='usertype']"));
		for (int i = 0; i < buttons.size(); i++) {
			WebElement required_button = buttons.get(i);
			String value = required_button.getAttribute("value");
			System.out.println(value);
			
			if (value.contentEquals("user")) {
				required_button.click();
			}
			
		}
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id = 'okayBtn']"))).click();
		//driver.switchTo().alert().accept();	
		driver.findElement(By.xpath("//input[@type = 'checkbox']")).click();
		driver.findElement(By.id("signInBtn")).click();
		w.until(ExpectedConditions.urlToBe("https://rahulshettyacademy.com/angularpractice/shop"));
		
		
		List<WebElement> product = driver.findElements(By.xpath("//button[@class = 'btn btn-info']"));
		for (int i= 0; i < product.size(); i++) {
			product.get(i).click();
		}
		
		driver.findElement(By.xpath("//a[@class = 'nav-link btn btn-primary']")).click();
		driver.findElement(By.xpath("//button[@class = 'btn btn-success']")).click();
		
		driver.findElement(By.id("country")).sendKeys("Ind");
		w.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class = 'suggestions']")));
		List<WebElement> country_options = driver.findElements(By.xpath("//div[@class = 'suggestions'] /ul /li /a"));
		for (int i = 0; i < country_options.size(); i++) {
			WebElement required_country = country_options.get(i);
			if (required_country.getText().equalsIgnoreCase("India")) {
				required_country.click();
			}
			break;
		}
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//label[@for = 'checkbox2']")).click();
		driver.findElement(By.xpath("//input[@class = 'btn btn-success btn-lg']")).click();
		}
}
