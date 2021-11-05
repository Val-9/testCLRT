package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.*;

import java.util.concurrent.TimeUnit;


public class BaseTest {

    private WebDriver driver;
    public MainPage main;
    public ProductCardPage productCardPage;
    public CartPage cartPage;
    public CheckOutPage checkOutPage;


    @BeforeMethod

    public void  start() {
       //   WebDriverManager.chromedriver().setup();
      //    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
      //    System.setProperty("webdriver.chrome.driver", "C:\\QA\\AutoTesting\\Color-it\\chromedriver.exe");
        //    System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        //    System.setProperty("webdriver.gecko.driver", "C:\\QA\\AutoTesting\\Color-it\\geckodriver.exe");
      //  options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
      //  options.addArguments("--remote-debugging-port=9222");
        System.setProperty("webdriver.firefox.driver", "/usr/local/bin/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
     //   options.addArguments("--headless");
        options.addArguments("--no-sandbox"); // Bypass OS security mode
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        driver = new FirefoxDriver(options);
        main = PageFactory.initElements(driver, MainPage.class);
        productCardPage = PageFactory.initElements(driver, ProductCardPage.class);
        cartPage = PageFactory.initElements(driver, CartPage.class);
        checkOutPage = PageFactory.initElements(driver, CheckOutPage.class);

     }
    @AfterMethod
    public void close() {

       driver.quit();
    }
}
