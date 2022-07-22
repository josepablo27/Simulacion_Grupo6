import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AtaqueSpam {

	public static void main(String[] args) throws InterruptedException {

		// Configuración inicial de web driver
		System.setProperty("webdriver.chrome.driver", "src\\resources\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		int x = 1;
		String url = "https://www.automationexercise.com/login";

		// Registrarse

		driver.get(url);

		while (true) {
			driver.findElement(By.className("fa-lock")).click();
			driver.findElement(By.name("name")).sendKeys("AtaqueSpam");
			Thread.sleep(2000);

			// Llenar el campo email correcto
			if (1 == 1) {
				List<WebElement> emails = driver.findElements(By.name("email"));
				emails.get(1).sendKeys(email(x));
			}
			x += 1;
			Thread.sleep(2000);
			// Tocar el botón correcto
			List<WebElement> buttoms = driver.findElements(By.className("btn-default"));
			//buttoms.get(1).click();

			// *******************************************//

			// Llenar el formulario

			driver.findElement(By.id("password")).sendKeys("contrasena");
			Thread.sleep(2000);
			driver.findElement(By.id("first_name")).sendKeys("Ataque");
			Thread.sleep(2000);
			driver.findElement(By.id("last_name")).sendKeys("Spam");
			Thread.sleep(2000);
			driver.findElement(By.id("address1")).sendKeys("Alabama");
			Thread.sleep(2000);
			driver.findElement(By.id("state")).sendKeys("Rumania");
			Thread.sleep(2000);
			driver.findElement(By.id("city")).sendKeys("Toronto");
			Thread.sleep(2000);
			driver.findElement(By.id("zipcode")).sendKeys("123");
			Thread.sleep(2000);
			driver.findElement(By.id("mobile_number")).sendKeys("321");
			Thread.sleep(2000);

			driver.findElement(By.className("btn-default")).click();

			// *******************************************//

			// Click en botón de continuar

			driver.findElement(By.className("btn-primary")).click();

			// *******************************************//

			String mainTab = driver.getWindowHandle();

			// Para abrir una nueva pestaña
			((JavascriptExecutor) driver).executeScript("window.open(arguments[0])", url);
			Thread.sleep(2000);

			Set<String> handles = driver.getWindowHandles();
			// Para controlar la pestaña que se acaba de crear
			for (String actual : handles) {
				System.out.println("-- Handled ID: " + actual);

				if (!actual.equalsIgnoreCase(mainTab)) {
					System.out.println("cambiando el tab");
					driver.switchTo().window(actual);
				}
			}

		}

	}

	// *******************************************//

	// Generador de Emails

	public static String email(int x) {

		int j = 1;
		String email = "@emailfake.net";

		while (true) {

			if (j == x) {
				String nEmail = j + email;
				System.out.println(nEmail);
				return nEmail;
			}
			j += 1;
		}
	}
}
