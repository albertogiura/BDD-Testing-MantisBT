package io.cucumber.mantis;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/SystemTestReports/html"},
                features = "src/test/resources/io/cucumber/mantis/",
                glue = {"io.cucumber.mantis.stepdefinitions", "io.cucumber.mantis.hooks"}
)
public class RunCucumberTest {
}
