package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {


    @Test
     public void verifyCartPage () throws InterruptedException {

         main.
                  goToMain()
                 .editQuantity("000") //1
                 .addToCart()
                 .goToCart();
        cartPage.
                 verifyCartPage()
                .checkMinAmountOrder();




    }

}
