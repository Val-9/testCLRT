package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;

public class Test {

    @org.testng.annotations.Test
    public void TestJenkins (){

        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
              options.addArguments("--no-sandbox"); // Bypass OS security model
              options.addArguments("--headless");
              options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
              options.addArguments("--remote-debugging-port=9222");
       WebDriver driver = new FirefoxDriver(options);
       driver.get("https://www.google.com");
        WebElement inputSearch = driver.findElement(By.cssSelector("input[class = 'gLFyf gsfi']"));
        System.out.println(inputSearch.getAttribute("name"));
        System.out.println("TEST TEST NO LaUNCH BROWSER");

    }
}
