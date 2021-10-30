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
        Thread.sleep(5000);
        WebElement input = driver.findElement(By.cssSelector("h3[class = 'style_heading__306pO']"));
        Assert.assertEquals(input.getText(), "Новинки");
    }
    @org.testng.annotations.Test
    public void TestJenkins2 (){

        driver.get("https://www.google.com");
        WebElement inputSearch = driver.findElement(By.cssSelector("input[class = 'gLFyf gsfi']"));
        Assert.assertEquals(inputSearch.getAttribute("name"), "w");
        System.out.println(inputSearch.getAttribute("name"));
        System.out.println("Google TEST Success");

    }
}

