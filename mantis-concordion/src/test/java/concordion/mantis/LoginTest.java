package concordion.mantis;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import static concordion.mantis.util.Constants.LOGIN_PAGE_URL;

@RunWith(ConcordionRunner.class)
public class LoginTest extends BaseFixture {

    public void loginWithCredentials(String username, String password){
        driver.get(LOGIN_PAGE_URL);
        authFacade.loginWithCredentials(username, password);
    }

    public Boolean theUserIsProvidedWithAErrorMessage() {
        return authFacade.isAuthErrorDisplayed();
    }
}
