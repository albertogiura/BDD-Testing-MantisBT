package io.cucumber.mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ReportBugPage extends BasePage {

    //WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@type = 'submit']")
    private WebElement reportIssueButton;

    @FindBy(how = How.XPATH, using = "//div[@id='main-container']/div[2]/div[2]/div/div/div/div[2]/div[2]/div/table/tbody/tr[2]/td")
    private WebElement projectName;

    @FindBy(how = How.ID, using = "summary")
    private WebElement summary;

    @FindBy(how = How.ID, using = "bug_id")
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

    public String getCurrentProjectName() {
        // TODO fix locator
        return projectName.getText();
    }

    public String getCurrentBugID() {
        return currentBugID.getText();
    }
}
