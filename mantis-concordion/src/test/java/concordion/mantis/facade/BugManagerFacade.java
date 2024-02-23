package concordion.mantis.facade;

import concordion.mantis.pages.ReportBugPage;
import concordion.mantis.pages.ViewAllBugsPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static concordion.mantis.util.Constants.REPORT_BUG_PAGE_URL;

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

    public void createNewBug(String reproducibility, String severity, String priority,
                             String summary, String description) {
        //driver.get(REPORT_BUG_PAGE_URL);
        goToReportIssuePage();
        setValueGivenProperty("reproducibility", reproducibility);
        setValueGivenProperty("severity", severity);
        setValueGivenProperty("priority", priority);
        setNewIssueSummary(summary);
        setNewIssueDescription(description);
        confirmNewBugReport();
    }
}
