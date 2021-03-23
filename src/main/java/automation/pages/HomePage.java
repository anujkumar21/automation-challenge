package automation.pages;

import automation.utils.Services;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * This class contains all locators and action methods related to Home page.
 */
public class HomePage {

    public static final String SUCCESS_MESSAGE = "Du bist nun bei Contorion angemeldet.";
    private static final Logger logger = LogManager.getLogger(HomePage.class);
    private static final String XPATH_ACCEPT_EVERYTHING = "//button[@id='popin_tc_privacy_button']";
    private static final String XPATH_ACCOUNT_ICON = "//div[contains(@class,'header__main')]//i[contains(@class,'icon--account header')]";
    private static final String XPATH_EMAIL = "//input[@id='login_email']";
    private static final String XPATH_PASSWORD = "//input[@id='login_password']";
    private static final String XPATH_LOGIN_BTN = "//span[text()='Jetzt anmelden']";
    private static final String XPATH_SUCCESS_MSG = "//div[contains(@class, 'alert--success')]//div[contains(@class, 'item--fit')]";
    private static final String XPATH_SEARCH = "//input[@name='q']";
    private static final String XPATH_SEARCH_BTN = "//button[@id='search-button']";
    private final Services services;

    public HomePage(WebDriver driver) {
        services = new Services(driver);
    }

    /**
     * This method is to click on accept all cookies.
     */
    public void clickOnAcceptEverything() {
        logger.info("Click on Accept Everything button.");
        services.click(XPATH_ACCEPT_EVERYTHING);
    }

    /**
     * This method is to open login option in menu.
     */
    public void openLoginMenu() {
        logger.info("Hover mouse on Account Icon.");
        services.hoverOver(XPATH_ACCOUNT_ICON);
    }

    /**
     * This method is to enter email into email field.
     *
     * @param email: user's email address
     */
    public void enterEmail(String email) {
        logger.info("Enter email {} into email field.", email);
        services.type(XPATH_EMAIL, email);
    }

    /**
     * This method is to enter password into password field.
     *
     * @param password: user's password
     */
    public void enterPassword(String password) {
        logger.info("Enter password {} into password field.", password);
        services.type(XPATH_PASSWORD, password);
    }

    /**
     * This method is to click on login button.
     */
    public void clickLoginBtn() {
        logger.info("Click on Login button.");
        services.click(XPATH_LOGIN_BTN);
    }

    /**
     * This method is to get success message after log in into application.
     *
     * @return success message
     */
    public String getSuccessMessage() {
        String successMsg = services.getText(XPATH_SUCCESS_MSG);
        logger.info("Actual message '{}' after login.", successMsg);
        return successMsg;
    }

    /**
     * This method is to search products.
     *
     * @param searchTxt: search string
     */
    public void search(String searchTxt) {
        logger.info("Enter {} into search field.", searchTxt);
        services.type(XPATH_SEARCH, searchTxt);
        logger.info("Click on Search button.");
        services.click(XPATH_SEARCH_BTN);
    }
}
