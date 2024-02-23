package io.cucumber.mantis.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.mantis.facade.AuthenticationFacade;
import io.cucumber.mantis.util.DriverLocator;
import org.openqa.selenium.WebDriver;

import static io.cucumber.mantis.util.Constants.LOGIN_PAGE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class AuthenticationStepDefinitions {
    WebDriver driver;
    AuthenticationFacade authFacade;

    public AuthenticationStepDefinitions() {
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

    @When("the user fills the fields with username {string} and password {string}")
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
