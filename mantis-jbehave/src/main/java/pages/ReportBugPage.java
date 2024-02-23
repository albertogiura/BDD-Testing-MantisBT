package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ReportBugPage extends BasePage {

    @FindBy(how = How.ID, using = "summary")
    private WebElement summary;

    @FindBy(how = How.CSS, using = "body.skin-3:nth-child(2) div.main-container:nth-child(3) div.main-content div.page-content div.row div.col-md-12.col-xs-12:nth-child(1) div.widget-box.widget-color-blue2 div.widget-body div.widget-main.no-padding div.table-responsive table.table.table-bordered.table-condensed tbody:nth-child(2) tr.bug-header-data:nth-child(2) > td.bug-id")
    private WebElement currentBugID;

    @FindBy(how = How.ID, using = "description")
    private WebElement description;

    @FindBy(how = How.XPATH, using = "//input[@value='Submit Issue']")
    private WebElement submitIssueButton;

    public ReportBugPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void submitIssue() {
        submitIssueButton.click();
    }

    public String getCurrentBugID() {
        return currentBugID.getText();
    }

    public WebElement getSummaryField() {
        return summary;
    }

    public WebElement getDescriptionField() {
        return description;
    }
}
