package io.cucumber.mantis.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AuthenticationStepDefinitions {
    WebDriver driver = new ChromeDriver();
    String current_user = "";

    @Given("a user that opens the login page")
    public void a_user_that_opens_the_login_page() {
        driver.get("http://127.0.0.1/mantisbt/login_page.php");
    }

    @When("the user fills the fields with username {string} and password {string}")
    public void the_user_fills_the_fields_with_username_and_password(String username, String password) {

        WebElement usernameTextBox = driver.findElement(By.id("username"));

        usernameTextBox.sendKeys(username);
        current_user = username;

        driver.findElement(By.xpath("//input[@type = 'submit']")).click();

        WebElement pwdTextBox = driver.findElement(By.id("password"));

        pwdTextBox.sendKeys(password);

        driver.findElement(By.xpath("//input[@type = 'submit']")).click();
    }

    @Then("the user reaches the dashboard page")
    public void the_user_reaches_the_dashboard_page() {
        //assertEquals("http://127.0.0.1/mantisbt/my_view_page.php", driver.getCurrentUrl());
        assertEquals(current_user, driver.findElement(By.className("user-info")).getText());
        current_user = "";
    }

    @Then("the user is provided with a error message")
    public void theUserIsProvidedWithAErrorMessage() {
        assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    /*@After
    public void closeBrowser()
    {
        // Close browser window
        driver.quit();
    }*/
}
