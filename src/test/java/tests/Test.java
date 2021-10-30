package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Test extends BaseTest {



    @org.testng.annotations.Test
    public void TestJenkins () throws InterruptedException {

        main.goToMain();
        WebElement h3 = driver.findElement(By.cssSelector(".style_heading__306pO"));
        Assert.assertEquals(h3.getText(), "НОВИНКИ");
    }

    @org.testng.annotations.Test
    public void TestJenkins2 () throws InterruptedException {

        driver.get("https://www.google.com");
        WebElement input = driver.findElement(By.name("q"));
        Assert.assertEquals(input.getAttribute("name"), "q");
        System.out.println(input.getAttribute("name"));
        System.out.println("Google TEST Success");

    }
}

