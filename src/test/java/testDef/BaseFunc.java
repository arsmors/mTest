package testDef;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseFunc {

    public WebDriver driver;

    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public void openPage(String url) {
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public List<WebElement> getElements(By by) {
        Assert.assertFalse("No elements found", driver.findElements(by).isEmpty());
        return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public WebElement getElement(By by) {
        try {
            return new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found");
            return null;
        }
    }

    public void waitForElementTobeVisible(By by) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitForElementTobeInVisible(By by) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
}
