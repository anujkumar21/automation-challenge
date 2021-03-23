package automation.steps;

import automation.pages.PageFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static automation.pages.HomePage.SUCCESS_MESSAGE;
import static org.junit.Assert.assertEquals;

/**
 * This class is having all Given, When, Then actions which can be performed on Home page
 * and are mapped with steps mentioned in the feature files.
 */
public class HomePageSteps {
    final PageFactory page = PageFactory.getInstance();

    @When("User opens login menu options")
    public void user_opens_login_context_menu() {
        page.getHomePage().openLoginMenu();
    }

    @When("Enters email {string}")
    public void enters_email(String email) {
        page.getHomePage().enterEmail(email);
    }

    @When("Enters password {string}")
    public void enters_password(String password) {
        page.getHomePage().enterPassword(password);
    }

    @When("Clicks on login button")
    public void clicks_on_login_button() {
        page.getHomePage().clickLoginBtn();
    }

    @Then("Verify user should be logged in")
    public void verify_user_should_be_logged_in() {
        String actualMessage = page.getHomePage().getSuccessMessage();
        assertEquals(SUCCESS_MESSAGE, actualMessage);
    }

    @Then("User searches for {string}")
    public void user_searches_for(String searchTxt) {
        page.getHomePage().search(searchTxt);
    }

}
