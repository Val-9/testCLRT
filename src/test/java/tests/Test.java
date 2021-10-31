package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Test extends BaseTest  {
    WebDriver driver;

    @org.testng.annotations.Test
    public void TestJenkins2 () throws InterruptedException {
        driver.get("https://www.google.com");
        WebElement input = driver.findElement(By.name("q"));
        Assert.assertEquals(input.getAttribute("name"), "q");
        System.out.println(input.getAttribute("name"));
        driver.get("https://color-it.ua");
        Thread.sleep (10000);
        System.out.println(driver.getTitle());
        WebElement banner = driver.findElement(By.cssSelector("span[class='style_logo__XsOQq']"));
        System.out.println(banner.getAttribute("title"));
        WebElement seeAll = driver.findElement(By.cssSelector(".style_link__5n7xe"));
        System.out.println(seeAll.getText());
        System.out.println("Google TEST Success");
    }

    @org.testng.annotations.Test
    public void TestJenkins () throws InterruptedException {
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.get("https://color-it.ua");
        System.out.println(driver.getTitle());
        WebElement banner = driver.findElement(By.cssSelector("span[class='style_logo__XsOQq']"));
        System.out.println(banner.getAttribute("title"));
        WebElement seeAll = driver.findElement(By.cssSelector(".style_link__5n7xe"));
        System.out.println(seeAll.getText());

    }


}

