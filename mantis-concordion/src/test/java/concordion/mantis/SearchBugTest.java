package concordion.mantis;

import concordion.mantis.facade.BugManagerFacade;
import org.concordion.api.BeforeExample;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import static concordion.mantis.util.Constants.ALL_BUGS_PAGE_URL;
import static org.junit.Assert.assertEquals;

@RunWith(ConcordionRunner.class)
public class SearchBugTest extends BaseFixture {

    String lastBugID = "";
    BugManagerFacade bugManager;

    @BeforeExample
    public void facadeSetup(){
        bugManager = new BugManagerFacade(driver);
    }

    public String getCurrentProjectName() {
        return bugManager.getCurrentProjectName();
    }

    public void theUserReachesTheIssuesPage() {
        bugManager.goToIssuesPage();
        assertEquals(ALL_BUGS_PAGE_URL, driver.getCurrentUrl());
    }

    public void picksTheMostRecentBug() {
        lastBugID = bugManager.getMostRecentBugID();
        bugManager.searchBugByID(lastBugID);
        assertEquals(lastBugID, bugManager.getCurrentBugID());
        lastBugID = "";
    }
}
