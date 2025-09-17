import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	@SuppressWarnings("deprecation")

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sony\\eclipse\\java-2022-06\\WebDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// WebDriverWait w = new WebDriverWait(driver, 5); //Deprecated
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		String[] Veggies = { "Cucumber", "Brocolli", "Beetroot", "Brinjal" };

		Thread.sleep(2000L);

		Items(driver, Veggies);

//		Base a = new Base();
//
//		a.Items(driver, Veggies);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		// Explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

		// Explicit wait

	}

	public static void Items(WebDriver driver, String[] Veggies) {

		int j = 0;

		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String[] name1 = products.get(i).getText().split("-");
			String trimmedName = name1[0].trim();

			List al = Arrays.asList(Veggies);

			if (al.contains(trimmedName)) {

				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;

				if (j == Veggies.length) {
					break;
				}
			}
		}

	}
}
