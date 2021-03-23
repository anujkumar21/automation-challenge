package automation.steps;

import automation.pages.PageFactory;
import automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static automation.commons.Constants.URL;


/**
 * This class is having all Before & After methods which are executed before & after every scenario.
 */
public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);

    WebDriver driver;

    /**
     * This method is executed before every scenario and is used for instantiating driver & page factory.
     */
    @Before
    public void setUp() {
        driver = DriverManager.getWebDriver();
        PageFactory.setInstance(driver);
    }

    @Given("User is on home page")
    public void user_is_on_home_page() {
        logger.info("Launching application: " + URL);
        driver.get(URL);
        PageFactory.getInstance().getHomePage().clickOnAcceptEverything();
    }

    /**
     * This method is executed after every scenario and is used for quiting driver
     * & capturing screenshot in case of failure.
     *
     * @param scenario scenario
     */
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            logger.info("Capturing screenshot for failed scenario: " + scenario.getName());
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        DriverManager.removeWebDriver();
    }
}
