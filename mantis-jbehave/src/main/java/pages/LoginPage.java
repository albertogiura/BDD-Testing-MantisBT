package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import util.DriverLocator;

// This page object doesn't extend BasePage since it doesn't share common elements
public class LoginPage {
    WebDriver driver;

    @FindBy(how = How.ID, using = "username")
    private WebElement usernameTextBox;

    @FindBy(how = How.ID, using = "password")
    private WebElement pwdTextBox;

    @FindBy(how = How.XPATH, using = "//input[@type = 'submit']")
    private WebElement submitButton;

    @FindBy(how = How.CLASS_NAME, using = "user-info")
    private WebElement currentUser;

    @FindBy(how = How.CLASS_NAME, using = "alert-danger")
    private WebElement alertMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        usernameTextBox.sendKeys(username);
        submitButton.click();
    }

    public void enterPassword(String password) {
        pwdTextBox.sendKeys(password);
        submitButton.click();
    }

    public String getCurrentUser() {
        return currentUser.getText();
    }

    public boolean isAlertMessageDisplayed() {
        return alertMessage.isDisplayed();
    }
}
