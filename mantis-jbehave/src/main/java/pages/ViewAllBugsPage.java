package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ViewAllBugsPage extends BasePage {

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[2]/div[2]/div[1]/div[2]/form[1]/div[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[4]/a[1]")
    private WebElement mostRecentBugID;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/table[1]/tfoot[1]/tr[1]/td[1]/div[1]/div[8]/form[1]/fieldset[1]/input[4]")
    private WebElement deleteBugReportButton;

    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/input[1]")
    private WebElement confirmBugReportDeleteButton;

    @FindBy(how = How.CLASS_NAME, using = "alert-danger")
    private WebElement alertMessage;

    public ViewAllBugsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getMostRecentBugID() {
        return mostRecentBugID.getText();
    }

    public void deleteBugReport() {
        deleteBugReportButton.click();
        confirmBugReportDeleteButton.click();
    }

    public boolean isAlertMessageDisplayed() {
        return alertMessage.isDisplayed();
    }

}
