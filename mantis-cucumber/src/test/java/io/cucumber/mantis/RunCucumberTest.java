package io.cucumber.mantis;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("io/cucumber/mantis")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "src/test/resources/io/cucumber/mantis/")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "io.cucumber.mantis.stepdefinitions, io.cucumber.mantis.hooks")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "not @internal")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/SystemTestReports/report.html")
public class RunCucumberTest {
}
