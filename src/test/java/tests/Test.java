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

        driver.get("https://color-it.ua");
        main.waitVisibility(By.cssSelector(".style_link__5n7xe"));
        WebElement seeAll = driver.findElement(By.cssSelector(".style_link__5n7xe"));
        System.out.println(seeAll.getText());
        main.quantity.click();
        System.out.println(main.quantity.getAttribute("value"));
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

