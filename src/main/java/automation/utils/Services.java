package automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static automation.commons.Constants.EXPLICIT_TIMEOUT;
import static automation.commons.Constants.POLL_FREQUENCY;


/**
 * This class has all web driver actions.
 */
public class Services {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public Services(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, EXPLICIT_TIMEOUT, POLL_FREQUENCY);
    }

    /**
     * This method is to enter text into text field
     *
     * @param locator: xpath of element
     * @param text:    text to be entered
     */
    public void type(String locator, String text) {
        waitForElement(locator);
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    /**
     * This method is to click on web element.
     *
     * @param locator: xpath of element
     */
    public void click(String locator) {
        waitForElementClickable(locator);
        driver.findElement(By.xpath(locator)).click();
    }

    /**
     * This method is to get text present on web element
     *
     * @param locator: xpath of element
     * @return text
     */
    public String getText(String locator) {
        waitForElement(locator);
        return driver.findElement(By.xpath(locator)).getText();
    }

    /**
     * This method is to wait for element located.
     *
     * @param locator: xpath of element
     */
    public void waitForElement(String locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    /**
     * This method is to wait for element visibility.
     *
     * @param locator: xpath of element
     */
    public void waitForElementVisibility(String locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    /**
     * This method is to wait for element to be clickable..
     *
     * @param locator: xpath of element
     */
    public void waitForElementClickable(String locator) {
        waitForElementVisibility(locator);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    /**
     * This method is to hover on element.
     *
     * @param locator: xpath of element
     */
    public void hoverOver(String locator) {
        waitForElement(locator);
        WebElement element = driver.findElement(By.xpath(locator));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}

