package io.cucumber.mantis.facade;

import io.cucumber.mantis.pages.ReportBugPage;
import io.cucumber.mantis.pages.ViewAllBugsPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BugManagerFacade {
    WebDriver driver;
    ReportBugPage rbPage;
    ViewAllBugsPage allBugsPage;

    public BugManagerFacade(WebDriver driver) {
        this.driver = driver;
        rbPage = new ReportBugPage(driver);
        allBugsPage = new ViewAllBugsPage(driver);
    }

    public String getCurrentProjectName() {
        return rbPage.getCurrentProjectName();
    }

    public String getCurrentBugID() {
        return rbPage.getCurrentBugID();
    }

    public String getMostRecentBugID() {
        return allBugsPage.getMostRecentBugID();
    }
    public void goToReportIssuePage() {
        rbPage.getReportIssueSidebarButton().click();
    }

    public void goToIssuesPage() {
        rbPage.getViewAllIssuesSidebarButton().click();
    }
    public void setValueGivenProperty(String propId, String value) {
        rbPage.setPropertyValue(value, propId);
    }

    public void setNewIssueSummary(String summary) {
        rbPage.getSummaryField().click();
        rbPage.getSummaryField().clear();
        rbPage.getSummaryField().sendKeys(summary);
    }

    public void setNewIssueDescription(String description) {
        rbPage.getDescriptionField().click();
        rbPage.getDescriptionField().clear();
        rbPage.getDescriptionField().sendKeys(description);
    }

    public void confirmNewBugReport() {
        rbPage.submitIssue();
    }

    public void searchBugByID(String bugID) {
        rbPage.getBugIDSearchField().click();
        rbPage.getBugIDSearchField().clear();
        rbPage.getBugIDSearchField().sendKeys(bugID);
        rbPage.getBugIDSearchField().sendKeys(Keys.ENTER);
    }

    public Boolean isBugNotFoundErrorDisplayed() {
        return allBugsPage.isAlertMessageDisplayed();
    }

    public void deleteCurrentBugReport() {
        allBugsPage.deleteBugReport();
    }
}
