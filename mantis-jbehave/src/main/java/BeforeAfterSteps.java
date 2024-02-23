import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStories;
import util.DriverLocator;

import static util.Constants.LOGIN_PAGE_URL;
import static util.DriverLocator.createDriverInstance;
import static util.DriverLocator.getDriverInstance;

public class BeforeAfterSteps {

    @BeforeScenario
    public void StepsBeforeEachScenario() {
        // Code to be executed for each scenario, before step-definitions methods
        createDriverInstance();
    }

    @AfterScenario
    public void StepsAfterEachScenario() {
        // Code to be executed for each scenario, after step-definitions methods
        getDriverInstance().quit();
    }
}
