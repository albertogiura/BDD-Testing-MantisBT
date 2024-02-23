package io.cucumber.mantis.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static io.cucumber.mantis.util.DriverLocator.createDriverInstance;
import static io.cucumber.mantis.util.DriverLocator.getDriverInstance;

public class SystemHooks {

    @Before
    public void StepsBeforeEachScenario() {
        // Code to be executed for each scenario, before step-definitions methods
        createDriverInstance();
    }

    @After
    public void StepsAfterEachScenario() {
        // Code to be executed for each scenario, after step-definitions methods
        getDriverInstance().quit();
    }
}
