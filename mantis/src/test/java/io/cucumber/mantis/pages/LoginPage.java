package io.cucumber.mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    //WebDriver driver = null;

    @FindBy(how = How.ID, using = "username")
    private WebElement usernameTextBox;

    @FindBy(how = How.ID, using = "password")
    private WebElement pwdTextBox;

    @FindBy(how = How.XPATH, using = "//input[@type = 'submit']")
    private WebElement submitButton;

    @FindBy(how = How.CLASS_NAME, using = "user-info")
    private WebElement currentUser;

    @FindBy(how = How.CLASS_NAME, using = "alert-danger")
    private WebElement alertMessge;

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
        return alertMessge.isDisplayed();
    }
}
