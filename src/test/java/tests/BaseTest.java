package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
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

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    private WebDriver driver;
    public MainPage main;
    public ProductCardPage productCardPage;
    public CartPage cartPage;
    public CheckOutPage checkOutPage;


    @BeforeMethod

    public void  start() throws MalformedURLException, InterruptedException {
       //   WebDriverManager.chromedriver().setup();

      //    System.setProperty("webdriver.chrome.driver", "C:\\QA\\AutoTesting\\Color-it\\chromedriver.exe");
        //  System.setProperty("webdriver.gecko.driver", "C:\\QA\\AutoTesting\\Color-it\\geckodriver.exe");
      //    System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
      //    options.addArguments("--remote-debugging-port=9222");
      //
        System.setProperty("webdriver.firefox.driver", "/usr/local/bin/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
     // ChromeOptions options = new ChromeOptions();
    //  options.addArguments("--headless");
        options.addArguments("--no-sandbox"); // Bypass OS security mode
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problem
        options.addArguments("--remote-debugging-port=9222");
        driver = new FirefoxDriver(options);
        Dimension dimension = new Dimension(1600, 900);
        driver.manage().window().setSize(dimension);
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
