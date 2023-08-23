package testDef;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public class HomePage {
    BaseFunc baseFunc;

    public String homePage = "https://www.asos.com";
    private final By GENDER = By.xpath("//*[@class=\"src-GlobalBanner-Button-Button_button\"]");
    private final By PRODUCT_TILES = By.xpath("//*[contains(@id, 'product-')]");
    private final By STYLES_FOUND = By.xpath("//*[@class=\"styleCount_xO2z5\"]");
    private final By SIZE = By.xpath("//*[contains(@data-testid, 'size-')]");
    private final By ADD_TO_BAG = By.xpath("//*[@class='MRMAA']");
    private final By ADDED = By.xpath("//*[text()='Added']");
    private final By VARIANT_SELECTOR = By.xpath("//*[@id=\"variantSelector\"]");
    private final By ACCEPT_COOKIES = By.xpath("//*[@id='onetrust-accept-btn-handler']");
    private final By SIZE_GUIDE = By.xpath("//*[@class='dTL_Y']");


    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void openHomePage(String gender) {
        baseFunc.openPage(homePage);
        baseFunc.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        acceptCookies();
        selectGender(gender);
    }

    private void selectGender(String gender) {
        assertTrue(baseFunc.getElement(GENDER).isDisplayed());
        List<WebElement> items = baseFunc.getElements(GENDER);
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getText().equals(gender)) {
                items.get(i).click();
                break;
            }
        }
        assertTrue(baseFunc.getElement(STYLES_FOUND).isDisplayed());
    }

    private void acceptCookies() {
        baseFunc.waitForElementTobeVisible(ACCEPT_COOKIES);
        baseFunc.getElement(ACCEPT_COOKIES).click();
    }

    public void selectItems(int ads) {
        List<WebElement> items = baseFunc.getElements(PRODUCT_TILES);
        for (int i = 0; i < ads; i++) {
            items.get(i).click();
            selectSize();
            addToBag();
            goBackPageGesture();
        }
    }

    private void goBackPageGesture() {
        baseFunc.driver.navigate().back();
    }

    private void addToBag() {
        baseFunc.getElement(ADD_TO_BAG).click();
        assertTrue(baseFunc.getElement(ADDED).isDisplayed());
    }

    private void selectSize() {
        baseFunc.waitForElementTobeInVisible(SIZE_GUIDE);
        baseFunc.getElement(VARIANT_SELECTOR).click();
        List<WebElement> items = baseFunc.getElements(SIZE);
        items.get(0).click();
    }
}
