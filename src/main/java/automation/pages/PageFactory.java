package automation.pages;

import org.openqa.selenium.WebDriver;

/**
 * This class is for instantiating pages.
 */
public final class PageFactory {

    private static PageFactory pageFactory;
    private final HomePage homePage;
    private final ProductFilterPage productFilterPage;

    private PageFactory(WebDriver driver) {
        homePage = new HomePage(driver);
        productFilterPage = new ProductFilterPage(driver);
    }

    public static PageFactory getInstance() {
        return pageFactory;
    }

    public static void setInstance(WebDriver driver) {
        pageFactory = new PageFactory(driver);
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public ProductFilterPage getProductFilterPage() {
        return productFilterPage;
    }
}