package tests;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;


public class MainTest extends BaseTest {

    @FindBy(css = "a[class='style_btnCart__1WGKM linkBtn false'][title='Корзина']")
    private WebElement cartEmpty;

    @FindBy(css = "div.style_wrapper__2Y0Uz:nth-child(1)")
    private WebElement header;

    @FindBy(css = "div.style_wrapper__2Y0Uz:nth-child(2)")
    private WebElement categoryMenu;

    @FindBy(css = "div.style_wrapper__2Y0Uz:nth-child(3)")
    private WebElement headerOrderInfo;

    private void verifyMainPageNew() {
        WebElement cartEmpty = driver.findElement(By.cssSelector("a[class='style_btnCart__1WGKM linkBtn false'][title='Корзина']"));
        String headerText = "О Компании\n" + "Доставка и оплата\n" + "Акции\n" + "Отзывы\n" + "Контакты\n" + "Напишите нам в\n" + "Viber\n" + "или\n" + "Telegram";
        System.out.println(cartEmpty.getAttribute("href"));
        Assert.assertEquals(cartEmpty.getAttribute("href"), "https://color-it.ua/ca");

    }

    @Test
    public void MainPageTest2() throws InterruptedException {

        main
                .goToMain();
        this.verifyMainPageNew();
    }

    @Test
    public void MainPageTest3() throws InterruptedException {

        main
                .goToMain();
        Assert.assertEquals(cartEmpty.getAttribute("href"), "https://color-it.ua/cart");
    }

    @Test
    public void MainPageTest4() throws InterruptedException {

        main
                .goToMain();

       WebElement cartEmpty2 = driver.findElement(By.cssSelector("a[class='style_btnCart__1WGKM linkBtn false'][title='Корзина']"));
    }


    @Test
    public void MainPageTest() throws InterruptedException {

        main
                .goToMain()
                .verifyMainPage();
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
