package automation.pages;

import automation.utils.Services;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * This class contains all locators and action methods related to Product Filter page.
 */
public class ProductFilterPage {

    private static final Logger logger = LogManager.getLogger(ProductFilterPage.class);
    private static final String XPATH_FILTER_HEADING = "//h2/span";

    private final Services services;

    public ProductFilterPage(WebDriver driver) {
        services = new Services(driver);
    }

    /**
     * This method is to get applied filter heading on Product Filter page.
     *
     * @return applied filter heading
     */
    public String getAppliedFilterHeading() {
        String appliedFilter = services.getText(XPATH_FILTER_HEADING);
        logger.info("Get applied filter '{}' on Product Filter page.", appliedFilter);
        return appliedFilter;
    }
}
