import facade.AuthenticationFacade;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.DriverLocator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static util.Constants.LOGIN_PAGE_URL;

public class AuthenticationSteps {
    WebDriver driver;
    AuthenticationFacade authFacade;

    @BeforeScenario
    public void StepsBeforeScenario() {
        // Code to be executed to setup this steps class before executing each scenario
        driver = DriverLocator.getDriverInstance();
        authFacade = new AuthenticationFacade(driver);
    }

    String current_user = "";

    @Given("a user that opens the login page")
    public void a_user_that_opens_the_login_page() {
        driver.get(LOGIN_PAGE_URL);
        assertEquals(LOGIN_PAGE_URL, driver.getCurrentUrl());
    }

    @Given("a logged in user")
    public void a_logged_in_user() {
        driver.get(LOGIN_PAGE_URL);
        assertEquals(LOGIN_PAGE_URL, driver.getCurrentUrl());

        // Change username and password with your credentials
        // Default username and password for MantisBT are "administrator" - "root"
        authFacade.loginWithCredentials("administrator", "root");
    }

    @When("the user fills the fields with username $username and password $password")
    public void the_user_fills_the_fields_with_username_and_password(String username, String password) {
        authFacade.loginWithCredentials(username, password);
        current_user = username;
    }

    @Then("the user reaches the dashboard page")
    public void the_user_reaches_the_dashboard_page() {
        assertEquals(current_user, authFacade.getLoggedInUser());
        current_user = "";
    }

    @Then("the user is provided with a error message")
    public void theUserIsProvidedWithAErrorMessage() {
        assertTrue(authFacade.isAuthErrorDisplayed());
    }

}
