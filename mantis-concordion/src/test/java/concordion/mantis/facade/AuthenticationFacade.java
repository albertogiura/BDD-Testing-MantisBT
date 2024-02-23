package concordion.mantis.facade;

import concordion.mantis.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class AuthenticationFacade {

    WebDriver driver;
    LoginPage loginPage;

    public AuthenticationFacade(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(driver);
    }

    public void loginWithCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    public String getLoggedInUser() {
        return loginPage.getCurrentUser();
    }

    public Boolean isAuthErrorDisplayed() {
        return loginPage.isAlertMessageDisplayed();
    }
}
