package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Test {

    @org.testng.annotations.Test
    public void TestJenkins (){

        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
              options.addArguments("--no-sandbox"); // Bypass OS security model
              options.addArguments("--headless");
              options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
              options.addArguments("--remote-debugging-port=9222");
       WebDriver driver = new FirefoxDriver(options);
       driver.get("www.google.com");
        System.out.println("TEST TEST NO LaUNCH BROWSER");

    }
}
