package automation.steps;

import automation.pages.PageFactory;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;

/**
 * This class is having all Given, When, Then actions which can be performed on Product Filter page
 * and are mapped with steps mentioned in the feature files.
 */
public class ProductFilterPageSteps {
    final PageFactory page = PageFactory.getInstance();

    @Then("Verify product filter page should have products filtered by {string}")
    public void verify_product_filter_page_should_have_products_filtered_by(String searchTxt) {
        String appliedFilter = page.getProductFilterPage().getAppliedFilterHeading();
        assertEquals(searchTxt, appliedFilter);
    }
}
