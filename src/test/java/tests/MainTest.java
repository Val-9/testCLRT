package tests;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.MainPage;


public class MainTest extends BaseTest {

    @FindBy(css = "a[class='style_btnCart__1WGKM linkBtn false'][title='Корзина']")
    public WebElement cartEmpty;

    @FindBy(css = "div.style_wrapper__2Y0Uz:nth-child(1)")
    public WebElement header;

    @FindBy(css = "div.style_wrapper__2Y0Uz:nth-child(2)")
    public WebElement categoryMenu;

    @FindBy(css = "div.style_wrapper__2Y0Uz:nth-child(3)")
    public WebElement headerOrderInfo;

    private void verifyMainPageNew() {

        String headerText = "О Компании\n" + "Доставка и оплата\n" + "Акции\n" + "Отзывы\n" + "Контакты\n" + "Напишите нам в\n" + "Viber\n" + "или\n" + "Telegram";
        System.out.println(cartEmpty.getAttribute("href"));
        System.out.println(cartEmpty.getAttribute("href"));
        Assert.assertEquals(cartEmpty.getAttribute("href"), "https://color-it.ua/ca");
        Assert.assertTrue(header.getText().contains(headerText));
        Assert.assertEquals(categoryMenu.getText(), "ТОВАРЫ ДЛЯ ШКОЛЫ\n" + "ТОВАРЫ ДЛЯ ОФИСА\n" + "СЕЗОННЫЕ ТОВАРЫ\n" + "ХОЗЯЙСТВЕННЫЕ ТОВАРЫ");
        Assert.assertEquals(headerOrderInfo.getText(), "Бесплатная доставка для заказов от\n" + " 5000 грн\n" + "Сумма минимального заказа\n" + " 1500 грн\n" + "Возврат и обмен в течение\n" + " 7 дней");

    }
    @Test
    public void MainPageTest() throws InterruptedException {

        main
                .goToMain();
                this.verifyMainPageNew();
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
