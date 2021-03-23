package automation.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static automation.commons.Constants.IMPLICIT_TIMEOUT;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * This class is responsible for managing web driver, like instantiating driver, quiting driver instances, etc.
 */
public class DriverManager {

    private static final Logger logger = LogManager.getLogger(DriverManager.class);
    private static WebDriver driver;

    private DriverManager() {
    }

    /**
     * This method is to instantiate web driver
     *
     * @return WebDriver instance
     */
    public static WebDriver getWebDriver() {
        logger.info("Instantiating driver");
        if (driver == null)
            driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, SECONDS);
        return driver;
    }

    /**
     * This method is to quiting driver instance.
     */
    public static void removeWebDriver() {
        logger.info("Quiting driver\n");
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
