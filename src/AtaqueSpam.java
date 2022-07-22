import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AtaqueSpam {

	public static void main(String[] args) {

		// Configuración inicial de web driver
		System.setProperty("webdriver.chrome.driver", "src\\resources\\drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		int x = 7;

		for(int p=0;p<=10;p++) {
		
		//Registrarse
		driver.get("https://www.automationexercise.com/login");
		driver.findElement(By.className("fa-lock")).click();
		driver.findElement(By.name("name")).sendKeys("AtaqueSpam");
		//Llenar el campo email correcto
		List<WebElement> emails = driver.findElements(By.name("email"));
		emails.get(1).sendKeys(email(x));
		x += 1;
		//Tocar el botón correcto
		List<WebElement> buttoms = driver.findElements(By.className("btn-default"));
		buttoms.get(1).click();
		
	//*******************************************//
		
		//Llenar el formulario
		
		driver.findElement(By.id("password")).sendKeys("contrasena");
		driver.findElement(By.id("first_name")).sendKeys("Ataque");
		driver.findElement(By.id("last_name")).sendKeys("Spam");
		driver.findElement(By.id("address1")).sendKeys("Alabama");
		driver.findElement(By.id("state")).sendKeys("Rumania");
		driver.findElement(By.id("city")).sendKeys("Toronto");
		driver.findElement(By.id("zipcode")).sendKeys("123");
		driver.findElement(By.id("mobile_number")).sendKeys("321");
		
		driver.findElement(By.className("btn-default")).click();
		
	//*******************************************//
		
		//Click en botón de continuar
		
		driver.findElement(By.className("btn-primary")).click();
		}
	}


	public static String email(int x) {

		int j = 1;
		String email = "@emailfake.com";

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
