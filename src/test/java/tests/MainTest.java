package tests;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;



public class MainTest extends BaseTest {
    WebDriver driver = new FirefoxDriver();


    @Test
    public void MainPageTest() throws InterruptedException {

        main
                .goToMain();
                WebElement test = driver.findElement(By.cssSelector("div.style_wrapper__2Y0Uz:nth-child(1) > div:nth-child(1)"));
                test.isDisplayed();
                main.verifyMainPage();
    }

    @Test (groups = {"smoke"})
    public void SearchTest() throws InterruptedException {
        main
                .goToMain()
                .searchProduct("краска")
                .verifySearch("краска")
                .clearSearchInput()
                .searchProduct("ручка")
                .verifySearch("ручка");

    }

    @Test
    public void addToCartAfterSearch () throws InterruptedException {
        main
                .goToMain()
                .searchProduct("ручка")
                .verifySearch("ручка")
                .addToCart()
                .verifyButtonInCart();
    }


    @Test
    public void addToCart () throws InterruptedException {
        main
                .goToMain()
                .editQuantity("00")
                .addToCart()
                .goToCart(); // перейти в корзину и проверить что товар есть в корзине.

}

    }
