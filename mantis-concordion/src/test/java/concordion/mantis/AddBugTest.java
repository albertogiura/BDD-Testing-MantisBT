package concordion.mantis;

import concordion.mantis.facade.BugManagerFacade;
import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class AddBugTest extends BaseFixture {
    BugManagerFacade bugManager;

    @BeforeExample
    public void facadeSetup(){
        bugManager = new BugManagerFacade(driver);
    }

    public void createNewBug(String reproducibility, String severity, String priority,
                             String summary, String description) {
        authenticateDefaultUser();
        bugManager.createNewBug(reproducibility, severity, priority,
                summary, description);
    }
}
