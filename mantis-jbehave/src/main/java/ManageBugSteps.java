
import facade.AuthenticationFacade;
import facade.BugManagerFacade;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.WebDriver;
import util.DriverLocator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static util.Constants.ALL_BUGS_PAGE_URL;
import static util.Constants.REPORT_BUG_PAGE_URL;

public class ManageBugSteps {
    WebDriver driver;
    BugManagerFacade bugManager;
    String lastBugID = "";

    @BeforeScenario
    public void StepsBeforeScenario() {
        // Code to be executed to setup this steps class before executing each scenario
        driver = DriverLocator.getDriverInstance();
        bugManager = new BugManagerFacade(driver);
    }

    @When("the user reaches the bug report page")
    public void the_user_reaches_the_bug_report_page() {
        // Click the "Report issue" button
        bugManager.goToReportIssuePage();
        assertEquals(REPORT_BUG_PAGE_URL, driver.getCurrentUrl());
    }

    @When("chooses $value as $propId for the issue")
    public void choosesValueForPropertyIssue(String value, String propId) {
        bugManager.setValueGivenProperty(propId, value);
    }

    @When("writes a title for the problem as $summary")
    public void writesATitleForTheProblemAsSummary(String summary) {
        bugManager.setNewIssueSummary(summary);
    }

    @When("writes some details about the issue as $descr")
    public void writesSomeDetailsAboutTheIssueAsDescription(String descr) {
        bugManager.setNewIssueDescription(descr);
    }

    @Then("a new bug is registered for that project")
    public void a_new_bug_is_registered_for_that_project() {
        bugManager.confirmNewBugReport();
        lastBugID = bugManager.getCurrentBugID();
    }

    @When("I look for a bug with ID $bugID")
    public void iLookForABugWithID(String bugID) {
        bugManager.searchBugByID(bugID);
    }

    @Then("the bug detail page for issue $bugID is displayed")
    public void theBugDetailPageForIssueIsDisplayed(String bugID) {
        assertEquals(bugID, bugManager.getCurrentBugID());
    }


    @Given("an existing project named $projectName")
    public void an_existing_project_named(String projectName) {
        assertEquals(projectName, bugManager.getCurrentProjectName());
    }

    @When("the user reaches the issues page")
    public void theUserReachesTheIssuesPage() {
        bugManager.goToIssuesPage();
        assertEquals(ALL_BUGS_PAGE_URL, driver.getCurrentUrl());
    }

    @When("picks the most recent bug")
    public void picksTheMostRecentBug() {
        lastBugID = bugManager.getMostRecentBugID();
        bugManager.searchBugByID(lastBugID);
    }

    @When("chooses to delete the bug report")
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
