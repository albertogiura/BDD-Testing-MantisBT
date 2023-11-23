package io.cucumber.mantis.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.mantis.pages.LoginPage;
import io.cucumber.mantis.pages.ReportBugPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BugStepDefinitions {
    WebDriver driver = new ChromeDriver();

    LoginPage loginPage = new LoginPage(driver);

    ReportBugPage rbPage = new ReportBugPage(driver);

    @Given("a logged in user")
    public void a_logged_in_user() {
        driver.get("http://127.0.0.1/mantisbt/login_page.php");

        // Change username and password with your credentials
        // Default username and password for MantisBT are "administrator" - "root"

        loginPage.enterUsername("administrator");
        loginPage.enterPassword("root");

        /*WebElement usernameTextBox = driver.findElement(By.id("username"));

        // Change username and password with your credentials
        // Default username and password for MantisBT are "administrator" - "root"

        usernameTextBox.sendKeys("administrator");

        driver.findElement(By.id("login-form")).submit();
        //driver.findElement(By.xpath("//input[@type = 'submit']")).click();

        WebElement pwdTextBox = driver.findElement(By.id("password"));

        pwdTextBox.sendKeys("stage");

        driver.findElement(By.id("login-form")).submit();
        //driver.findElement(By.xpath("//input[@type = 'submit']")).click();*/
    }

    @Given("an existing project named {string}")
    public void an_existing_project_named(String projectName) {
        // TODO fix locator
        //assertEquals(projectName, driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div[2]/div/div/div/div[2]/div[2]/div/table/tbody/tr[2]/td")).getText());
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
    }

    @When("the user reaches the bug report page")
    public void the_user_reaches_the_bug_report_page() {
        // Click the "Report issue" button
        driver.findElement(By.xpath("//div[@id='sidebar']/ul/li[3]/a/i")).click();
        assertEquals("http://127.0.0.1/mantisbt/bug_report_page.php", driver.getCurrentUrl());
    }

    // Step definition using Cucumber expressions
    /*@When("chooses/sets {string} as {string}")
    public void chooses_as_Reproducibility(String repr, String propId) {
        propId = propId.toLowerCase();
        new Select(driver.findElement(By.id(propId))).selectByVisibleText(repr);
    }*/

    /*@When("chooses {string} as Reproducibility")
    public void chooses_as_Reproducibility(String repr) {
        //Select dropdown = new Select(driver.findElement(By.id("reproducibility")));
        //dropdown.selectByVisibleText(repr);
        //driver.findElement(By.id("reproducibility")).click();
        new Select(driver.findElement(By.id("reproducibility"))).selectByVisibleText(repr);
    }

    @When("sets {string} as Severity")
    public void sets_as_Severity(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("chooses {string} as Priority")
    public void chooses_as_Priority(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }*/

    /*@When("writes {string} as Summary")
    public void writes_as_Summary(String string) {
        driver.findElement(By.id("summary")).click();
        driver.findElement(By.id("summary")).clear();
        driver.findElement(By.id("summary")).sendKeys("urgent issue");
    }

    @When("writes {string} in the description field")
    public void writes_in_the_description_field(String string) {
        driver.findElement(By.id("description")).click();
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys("happens everytime after login");
    }*/



    /*@And("chooses the {string} for the issue")
    public void choosesTheReproducibilityForTheIssue() {
    }*/

    @And("chooses {string} as {string} for the issue")
    public void choosesValueForPropertyIssue(String value, String propId) {
        new Select(driver.findElement(By.id(propId))).selectByVisibleText(value);
    }


    /*@And("chooses {string} as reproducibility for the issue")
    public void choosesReproducibilityAsReproducibilityForTheIssue(String repr) {
        //Select dropdown = new Select(driver.findElement(By.id("reproducibility")));
        //dropdown.selectByVisibleText(repr);
        //driver.findElement(By.id("reproducibility")).click();
        new Select(driver.findElement(By.id("reproducibility"))).selectByVisibleText(repr);
    }

    @And("chooses {string} as severity for the issue")
    public void choosesSeverityAsSeverityForTheIssue(String sev) {
        new Select(driver.findElement(By.id("severity"))).selectByVisibleText(sev);
    }


    @And("chooses {string} as priority for the issue")
    public void choosesPriorityAsPriorityForTheIssue(String priority) {
        new Select(driver.findElement(By.id("priority"))).selectByVisibleText(priority);
    }*/

    @And("writes a title for the problem as {string}")
    public void writesATitleForTheProblemAsSummary(String summary) {
        driver.findElement(By.id("summary")).click();
        driver.findElement(By.id("summary")).clear();
        driver.findElement(By.id("summary")).sendKeys(summary);
    }


    @And("writes some details about the issue as {string}")
    public void writesSomeDetailsAboutTheIssueAsDescription(String descr) {
        driver.findElement(By.id("description")).click();
        driver.findElement(By.id("description")).clear();
        driver.findElement(By.id("description")).sendKeys(descr);
    }

    @Then("a new bug is registered for that project")
    public void a_new_bug_is_registered_for_that_project() {
        // TODO
        rbPage.submitIssue();
    }

    /*@After
    public void closeBrowser()
    {
        // Close browser window
        //driver.quit();
    }*/
}
