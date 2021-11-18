package page;

import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class MainPage extends BasePage {



    @FindBy(css = "div.style_wrapper__2Y0Uz:nth-child(1)")
    private WebElement header;

    @FindBy(css = "div.style_wrapper__2Y0Uz:nth-child(2)")
    private WebElement categoryMenu;

    @FindBy(css = "div.style_wrapper__2Y0Uz:nth-child(3)")
    public WebElement headerOrderInfo;

    @FindBy(css = "input[class='style_input__352mX']")
    public WebElement inputSearch;

    @FindBy(css = "a[class='style_name__btju7 linkDefault']")
    public WebElement productNameSearch;
    String productNameSearchCssValue = "a[class='style_name__btju7 linkDefault']";

    @FindBy(css = "buttonInCart")
    public WebElement productNameOnMain;

    @FindBy(css = "span[class='style_logo__XsOQq'][title='Color-it']")
    public WebElement logo;

    @FindBy(css = "span[class='style_btnCartIcon__1Kkdo']")
    public WebElement cartEmpty;

    @FindBy(css = "a[class='style_btnCart__1WGKM linkBtn style_inCart__2J_nM'][title='Корзина']")
    public WebElement cartAmount;

    @FindBy(css = "button[class='style_btnCart__3zXoU btnDefault'][type='submit']")
    public WebElement buttonAddToCart;

    @FindBy(css = "a[class='style_btnCart__3zXoU btnDefault style_btnCartIn_art__nstr3'][title='В КОРЗИНЕ']")
    public WebElement buttonInCart;
    String buttonInCartCssValue = "a[class='style_btnCart__3zXoU btnDefault style_btnCartIn_art__nstr3'][title='В КОРЗИНЕ']";

    @FindBy(css = "a[class='style_name__btju7 linkDefault']")
    public WebElement productNameInCart;

    @FindBy(css = "input[class='style_input__32Nxn inputDefault'][name = 'qunatity']")
    public WebElement quantity;


    String headerText = "О Компании\n" + "Доставка и оплата\n" + "Акции\n" + "Отзывы\n" + "Контакты\n" + "Напишите нам в\n" + "Viber\n" + "или\n" + "Telegram";

    public MainPage(WebDriver driver) {
        super(driver) ;
    }

    public String captureScreen() {
        String path;
        WebDriver driver = new FirefoxDriver();
        try {
            WebDriver webDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            path = "./target/screenshots/" + source.getName();
            FileUtils.copyFile(source, new File(path));
        } catch (IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;


    }

        public MainPage goToMain() throws InterruptedException {
        driver.get("https://godex.io");
        System.out.println("Title is :" + " " + driver.getTitle());
        System.out.println("Size is :" + " " + driver.manage().window().getSize());
        this.captureScreen();

        return this;
    }

    public MainPage verifyMainPage() throws InterruptedException {
      waitVisibility(By.cssSelector("img[alt='google-download']"));
      WebElement google = driver.findElement(By.cssSelector("li.list-btn__item:nth-child(1) > button:nth-child(1) > img:nth-child(1)"));
        WebElement appstore = driver.findElement(By.cssSelector("li.list-btn__item:nth-child(2) > button:nth-child(1) > img:nth-child(1)"));
        WebElement revert = driver.findElement(By.cssSelector(".gdx-replace-button"));
        revert.click();
        WebElement exchButton = driver.findElement(By.cssSelector(".exchange-button"));




     /*   Assert.assertTrue(header.getText().contains(headerText));

        Assert.assertEquals(categoryMenu.getText(), "ТОВАРЫ ДЛЯ ШКОЛЫ\n" + "ТОВАРЫ ДЛЯ ОФИСА\n" + "СЕЗОННЫЕ ТОВАРЫ\n" + "ХОЗЯЙСТВЕННЫЕ ТОВАРЫ");
        System.out.println(headerOrderInfo.getText());
        Assert.assertEquals(headerOrderInfo.getText(), "Бесплатная доставка для заказов от\n" + " 5000 грн\n" + "Сумма минимального заказа\n" + " 1500 грн\n" + "Возврат и обмен в течение\n" + " 7 дней");
        return this; */
        return this;
    }

    public MainPage searchProduct(String product) throws InterruptedException {
        inputSearch.click();
        inputSearch.sendKeys(product);
        waitVisibility(By.cssSelector(productNameSearchCssValue));
        return this;
    }

    public MainPage clearSearchInput() {
        inputSearch.click();
        inputSearch.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        return this;

    }

    public MainPage verifySearch(String product) {
        Assert.assertTrue(productNameSearch.getText().toLowerCase().contains(product));
        return this;
    }

    public MainPage addToCart() throws InterruptedException {

        WebElement buttonAddToCartDefault = driver.findElement(By.cssSelector("button[class='style_btnCart__3zXoU btnDefault'][type='submit']"));
        buttonAddToCartDefault.click();
        Thread.sleep(2000);
        return this;

    }

    public MainPage verifyButtonInCart() {
        waitVisibility(By.cssSelector(buttonInCartCssValue));
        Assert.assertEquals(buttonInCart.getAttribute("className"), "style_btnCart__3zXoU btnDefault style_btnCartIn_art__nstr3");
        Assert.assertEquals(buttonInCart.getAttribute("href"), "https://color-it.ua/cart");
        Assert.assertEquals(buttonInCart.getAttribute("title"), "В КОРЗИНЕ");
        return this;
    }

    public MainPage editQuantity(String quantity1) {
        quantity.click();
        quantity.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
        quantity.sendKeys(quantity1);

        return this;
    }

    public MainPage getName (){
        String qwe = productNameOnMain.getText();
        System.out.println(qwe);
        return  this;
    }

    public MainPage goToCart() throws InterruptedException {
        buttonInCart.isDisplayed();
//        String textNameOnMain2 = productNameOnMain.getText();
        buttonInCart.click();
 //       String textNameInCart = productNameInCart.getText();
        return this;
    }

    }



