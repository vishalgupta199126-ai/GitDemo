import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Newassignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sony\\eclipse\\java-2022-06\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		// explicit wait
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		String[] item = { "iphone X", "Blackberry" };

		driver.findElement(By.cssSelector("input[id='username']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("learning");
		driver.findElement(
				By.xpath("//body/div[@id='login']/div[1]/div[1]/div[1]/div[1]/form[1]/div[4]/div[1]/label[2]/span[2]"))
				.click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='modal-body']")));
		driver.findElement(By.id("okayBtn")).click();

		// w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select[class='form-control']")));
		WebElement staticDropdown = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select dropdown = new Select(staticDropdown);

		dropdown.selectByIndex(2);
		System.out.println(dropdown.getFirstSelectedOption().getText());

		driver.findElement(By.xpath("//input[@id='terms']")).click();
		driver.findElement(By.cssSelector("input[id='signInBtn']")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.nav-link.btn.btn-primary")));
		value(driver, item);
		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

	}
	

	public static void value(WebDriver driver, String[] item) {

		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));

		for (int i = 0; i < products.size(); i++) {
			String name1 = products.get(i).getText();

			List al = Arrays.asList(item);

			if (al.contains(name1)) {

				driver.findElements(By.xpath("//div[@class='card-footer']/button")).get(i).click();
				j++;

				if (j == item.length) {
					break;
				}
			}
		}
	}

}