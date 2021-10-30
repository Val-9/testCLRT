package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BaseTest {

    public WebDriver driver;
    public MainPage main;
    public ProductCardPage productCardPage;
    public CartPage cartPage;
    public CheckOutPage checkOutPage;


    @BeforeMethod

    public void  start() {
     //     WebDriverManager.firefoxdriver().setup();
  //      System.setProperty("webdriver.gecko.driver", "C:\\QA\\AutoTesting\\Color-it\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--remote-debugging-port=9222");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver = new FirefoxDriver(options);
        main = PageFactory.initElements(driver, MainPage.class);
        productCardPage = PageFactory.initElements(driver, ProductCardPage.class);
        cartPage = PageFactory.initElements(driver, CartPage.class);
        checkOutPage = PageFactory.initElements(driver, CheckOutPage.class);

     }


      /*  System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new RemoteWebDriver(new URL("http://http://jenkins01.color-it.ua:4444/wd/hub"), options);*/




        //     DesiredCapabilities capabilities = new DesiredCapabilities();
        // If this cap isn't specified, it will just get any available one
        //       capabilities.setCapability("network", true); // To enable network logs
        //     capabilities.setCapability("visual", true); // To enable step by step screenshot
        //   capabilities.setCapability("video", true); // To enable video recording
        //   capabilities.setCapability("console", true); // To capture console logs

    @AfterMethod
    public void close() {

        driver.quit();
    }
}
