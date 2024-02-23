package concordion.mantis;

import concordion.mantis.facade.AuthenticationFacade;
import concordion.mantis.util.DriverLocator;
import org.concordion.api.AfterExample;
import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import static concordion.mantis.util.Constants.LOGIN_PAGE_URL;

@RunWith(ConcordionRunner.class)
public abstract class BaseFixture {
    protected WebDriver driver;
    protected AuthenticationFacade authFacade;

    @BeforeExample
    public void fixtureSetup() {
        DriverLocator.createDriverInstance();
        driver = DriverLocator.getDriverInstance();
        authFacade = new AuthenticationFacade(driver);
    }

    public void authenticateDefaultUser() {
        driver.get(LOGIN_PAGE_URL);

        // Change username and password with your credentials
        // Default username and password for MantisBT are "administrator" - "root"
        authFacade.loginWithCredentials("administrator", "root");
    }

    @AfterExample
    public void close() {
        DriverLocator.getDriverInstance().quit();
    }

    public void getURL(String url) {
        if (driver == null) {
            driver = DriverLocator.getDriverInstance();
        }
        driver.get(url);
    }
}
