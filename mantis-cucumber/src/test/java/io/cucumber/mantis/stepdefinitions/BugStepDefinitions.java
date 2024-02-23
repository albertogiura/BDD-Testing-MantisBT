package io.cucumber.mantis.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.mantis.facade.BugManagerFacade;
import io.cucumber.mantis.util.DriverLocator;
import org.openqa.selenium.WebDriver;

import static io.cucumber.mantis.util.Constants.ALL_BUGS_PAGE_URL;
import static io.cucumber.mantis.util.Constants.REPORT_BUG_PAGE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BugStepDefinitions {
    WebDriver driver;
    BugManagerFacade bugManager;

    String lastBugID = "";

    public BugStepDefinitions() {
        driver = DriverLocator.getDriverInstance();
        bugManager = new BugManagerFacade(driver);
    }

    @Given("an existing project named {string}")
    public void an_existing_project_named(String projectName) {
        assertEquals(projectName, bugManager.getCurrentProjectName());
    }

    @When("the user reaches the bug report page")
    public void the_user_reaches_the_bug_report_page() {
        // Click the "Report issue" button
        bugManager.goToReportIssuePage();
        assertEquals(REPORT_BUG_PAGE_URL, driver.getCurrentUrl());
    }

    @And("chooses {string} as {string} for the issue")
    public void choosesValueForPropertyIssue(String value, String propId) {
        bugManager.setValueGivenProperty(propId, value);
    }

    @And("writes a title for the problem as {string}")
    public void writesATitleForTheProblemAsSummary(String summary) {
        bugManager.setNewIssueSummary(summary);
    }

    @And("writes some details about the issue as {string}")
    public void writesSomeDetailsAboutTheIssueAsDescription(String descr) {
        bugManager.setNewIssueDescription(descr);
    }

    @Then("a new bug is registered for that project")
    public void a_new_bug_is_registered_for_that_project() {
        bugManager.confirmNewBugReport();
        lastBugID = bugManager.getCurrentBugID();
    }

    @When("I look for a bug with ID {string}")
    public void iLookForABugWithID(String bugID) {
        bugManager.searchBugByID(bugID);
    }

    @Then("the bug detail page for issue {string} is displayed")
    public void theBugDetailPageForIssueIsDisplayed(String bugID) {
        assertEquals(bugID, bugManager.getCurrentBugID());
    }

    // Use of traditional regular expression
    @When("(?:if\\s)?the user reaches the issues page$")
    public void theUserReachesTheIssuesPage() {
        bugManager.goToIssuesPage();
        assertEquals(ALL_BUGS_PAGE_URL, driver.getCurrentUrl());
    }

    @And("picks the most recent bug")
    public void picksTheMostRecentBug() {
        lastBugID = bugManager.getMostRecentBugID();
        bugManager.searchBugByID(lastBugID);
    }

    @And("chooses to delete the bug report")
    public void choosesToDeleteTheBugReport() {
        bugManager.deleteCurrentBugReport();
    }

    @Then("the stored bug id should not work anymore")
    public void theStoredBugIdShouldNotWorkAnymore() {
        bugManager.searchBugByID(lastBugID);
        assertTrue(bugManager.isBugNotFoundErrorDisplayed());
        lastBugID = "";
    }

    @Then("the bug detail page for that issue is displayed")
    public void theBugDetailPageForThatIssueIsDisplayed() {
        assertEquals(lastBugID, bugManager.getCurrentBugID());
    }
}
