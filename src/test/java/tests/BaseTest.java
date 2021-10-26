package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.*;
import java.io.File;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.util.concurrent.TimeUnit;


    public class BaseTest {

    public WebDriver driver;;
    public MainPage main;
    public ProductCardPage productCardPage;
    public CartPage cartPage;
    public CheckOutPage checkOutPage;


    @BeforeMethod
    public void start()throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--headless"); // Bypass OS security model
        WebDriver driver = new ChromeDriver(options);
        main = PageFactory.initElements(driver, MainPage.class);
        productCardPage= PageFactory.initElements(driver, ProductCardPage.class);
        cartPage= PageFactory.initElements(driver, CartPage.class);
        checkOutPage= PageFactory.initElements(driver, CheckOutPage.class);

    }

    @AfterMethod
    public void close() {

        driver.quit();
    }
}
