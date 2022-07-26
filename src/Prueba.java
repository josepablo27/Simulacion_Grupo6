import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Prueba {

    WebDriver driver;
    JavascriptExecutor jse;

    public void invokeChromeBrowser()
    {
    	System.setProperty("webdriver.chrome.driver", "src\\resources\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        disableChromeImages(options);
        driver = new ChromeDriver(options);

        driver.get("https://www.amazon.com/");

    }

    public static void disableChromeImages(ChromeOptions options)
    {
        HashMap<String, Object> images = new HashMap<String, Object>();
        images.put("images", 2);

        HashMap<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values", images);

        options.setExperimentalOption("prefs", prefs);

    }


    public static void main(String[] args) {

        Prueba Obj = new Prueba();
        Obj.invokeChromeBrowser();

    }

}