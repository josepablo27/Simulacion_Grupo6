import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pago {

	public static void main(String[] args) throws InterruptedException {

		//Inicializar el WebDriver
		System.setProperty("webdriver.chrome.driver", "src\\resources\\drivers\\chromedriver103.exe");
		WebDriver driver = new ChromeDriver();

		//Ingresar a la página web
		driver.get("https://www.automationexercise.com/login");
		Thread.sleep(2000);

		//Loguearse en la página

		List<WebElement> correo = driver.findElements(By.name("email"));
		correo.get(0).sendKeys("pagoinseguro@email.com");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("inseguro");
		Thread.sleep(2000);
		driver.findElement(By.className("btn-default")).click();

		//Ingresar el producto al carrito
		driver.findElement(By.linkText("View Product")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("cart")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("View Cart")).click();
		Thread.sleep(2000);
		
		//Proceder pago
		driver.findElement(By.className("check_out")).click();
		Thread.sleep(3000);
		driver.findElement(By.className("check_out")).click();
		Thread.sleep(3000);

		//Ingresar datos de pago

		List<WebElement> pago = driver.findElements(By.name("name_on_card"));
		pago.get(0).sendKeys("Mathias Gonzales");
		Thread.sleep(2000);
		driver.findElement(By.name("card_number")).sendKeys("5407-6238-8361-7802");
		Thread.sleep(2000);
		driver.findElement(By.name("cvc")).sendKeys("22");
		Thread.sleep(2000);
		driver.findElement(By.name("expiry_month")).sendKeys("08");
		Thread.sleep(2000);
		driver.findElement(By.name("expiry_year")).sendKeys("2025");
		Thread.sleep(2000);
		driver.findElement(By.className("submit-button")).click();
		
	}
}
