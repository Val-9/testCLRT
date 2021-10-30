package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.FindBy;

public class Test extends BaseTest {

    @org.testng.annotations.Test
    public void TestJenkins (){


        driver.get("https://www.google.com");
        WebElement inputSearch = driver.findElement(By.cssSelector("input[class = 'gLFyf gsfi']"));
        System.out.println(inputSearch.getAttribute("name"));
        System.out.println("TEST TEST NO LaUNCH BROWSER");

    }
}

