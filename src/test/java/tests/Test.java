package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Test extends BaseTest  {

    @org.testng.annotations.Test
    public void TestJenkins2 () throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement input = driver.findElement(By.name("q"));
        Assert.assertEquals(input.getAttribute("name"), "q");
        System.out.println(input.getAttribute("name"));
        driver.get("https://color-it.ua");
        Thread.sleep (15000);
        WebElement logo = driver.findElement(By.xpath("//*[@id='__next']/div[4]/header/div[2]/div/div/span/img"));
        main.goToMain().waitVisibility(By.cssSelector("span[class='style_logo__XsOQq']"));
        System.out.println(driver.getTitle());
        WebElement banner = driver.findElement(By.cssSelector("span[class='style_logo__XsOQq']"));
        System.out.println(banner.getAttribute("title"));
        WebElement seeAll = driver.findElement(By.cssSelector(".style_link__5n7xe"));
        System.out.println(seeAll.getText());
        System.out.println("Google TEST Success");
    }

    @org.testng.annotations.Test
    public void TestJenkins () throws InterruptedException {

        //   WebDriverManager.firefoxdriver().setup();
   //   System.setProperty("webdriver.gecko.driver", "C:\\QA\\AutoTesting\\Color-it\\geckodriver.exe");
       System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        //    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://color-it.ua");
        System.out.println(driver.getTitle());
        WebElement banner = driver.findElement(By.cssSelector("span[class='style_logo__XsOQq']"));
        System.out.println(banner.getAttribute("title"));
        WebElement seeAll = driver.findElement(By.cssSelector(".style_link__5n7xe"));
        System.out.println(seeAll.getText());

    }


}

