package concordion.mantis.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public abstract class BasePage {
    WebDriver driver = null;

    @FindBy(how = How.XPATH, using = "//*[@id='sidebar']/ul/li[2]/a")
    protected WebElement viewAllIssuesSidebarButton;

    @FindBy(how = How.XPATH, using = "//div[@id='sidebar']/ul/li[3]/a/i")
    protected WebElement reportIssueSidebarButton;

    @FindBy(how = How.XPATH, using = "//*[@id='dropdown_projects_menu']/a")
    protected WebElement currentProjectName;

    @FindBy(how = How.XPATH, using = "//*[@id='nav-search']/form/span/input")
    protected WebElement bugIDSearchField;

    public void getURL(String url) {
        driver.get(url);
    }

    public WebElement getViewAllIssuesSidebarButton() {
        return viewAllIssuesSidebarButton;
    }
    public WebElement getReportIssueSidebarButton() {
        return reportIssueSidebarButton;
    }

    public WebElement getBugIDSearchField() {
        return bugIDSearchField;
    }

    public String getCurrentProjectName() {
        return currentProjectName.getText().substring(1, currentProjectName.getText().length()-1);
    }

    public void setPropertyValue(String value, String propId) {
        new Select(driver.findElement(By.id(propId))).selectByVisibleText(value);
    }
}
