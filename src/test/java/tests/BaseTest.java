package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {

    public WebDriver driver;;
    public MainPage main;
    public ProductCardPage productCardPage;
    public CartPage cartPage;
    public CheckOutPage checkOutPage;
    String node = "http://http://jenkins01.color-it.ua:4444/wd/hub";

    @BeforeMethod

        public RemoteWebDriver start() throws InterruptedException, MalformedURLException {
      /*  System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--headless");
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--remote-debugging-port=9222");
        WebDriver driver = new RemoteWebDriver(new URL("http://http://jenkins01.color-it.ua:4444/wd/hub"), options);

  /*          WebDriverManager.firefoxdriver().setup();
        //    System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
            FirefoxOptions options = new FirefoxOptions();

            options.addArguments("--no-sandbox"); // Bypass OS security model
            options.addArguments("--headless");
        //    options.addArguments("disable-infobars"); // disabling infobars
        //    options.addArguments("--disable-extensions"); // disabling extensions
      //      options.addArguments("--disable-gpu"); // applicable to windows os only
            options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
            options.addArguments("--remote-debugging-port=9222");
         //   driver = new FirefoxDriver(options);      */

        URL hubUrl = new URL(node);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "firefox");
        capabilities.setCapability("version", "93.0");
        capabilities.setCapability("platform", "linux");
        return new RemoteWebDriver(hubUrl, capabilities);


   //     DesiredCapabilities capabilities = new DesiredCapabilities();
       // If this cap isn't specified, it will just get any available one
 //       capabilities.setCapability("network", true); // To enable network logs
   //     capabilities.setCapability("visual", true); // To enable step by step screenshot
     //   capabilities.setCapability("video", true); // To enable video recording
     //   capabilities.setCapability("console", true); // To capture console logs
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
