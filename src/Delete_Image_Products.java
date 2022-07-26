import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Delete_Image_Products {
	
	WebDriver driver;
    JavascriptExecutor jse;
    
	public static void main(String[] args) throws InterruptedException {

		// Configuracion del WebDriver y se hace el llamado de la funcion.

		
		System.setProperty("webdriver.chrome.driver", "src\\resources\\drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		Eliminar_imagenes(options);
		WebDriver driver = new ChromeDriver(options);
		
		// Se ingresa a la pagina y se realiza el login.
		
		driver.get("https://www.automationexercise.com/login");
		Thread.sleep(2000);
		
		
		List<WebElement> correo = driver.findElements(By.name("email"));
		correo.get(0).sendKeys("borrar@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys("productos");
		Thread.sleep(2000);
		driver.findElement(By.className("btn-default")).click();
		Thread.sleep(4000);
		
		// Entra a la pagina, y se verifica la eliminacion de imagenes productos de la interfaz.
		
		driver.findElement(By.xpath("//a[@href='/brand_products/Polo']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//a[@href='/brand_products/Madame']")).click();
		Thread.sleep(4000);
		
	    Select select = new Select(driver.findElement(By.className("features_items")));
	    select.selectByVisibleText("No hay nada para mostrar");
	    Thread.sleep(5000);			
}
	
	// Eliminacion de las imagenes de los productos de la pagina.
	
	  public static void Eliminar_imagenes(ChromeOptions options)
	    {
	        HashMap<String, Object> images = new HashMap<String, Object>();
	        images.put("images", 2);

	        HashMap<String, Object> prefs = new HashMap<String, Object>();
	        prefs.put("profile.default_content_setting_values", images);

	        options.setExperimentalOption("prefs", prefs);

	    }
}