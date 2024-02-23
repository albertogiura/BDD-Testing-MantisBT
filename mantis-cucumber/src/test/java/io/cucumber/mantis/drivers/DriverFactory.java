package io.cucumber.mantis.drivers;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
    public static WebDriver initBrowserDriver(String browser) {
        BrowserDriver browserDriver;

        if (browser.equalsIgnoreCase("firefox")) {
            browserDriver = new FirefoxBrowserDriver();
        } else {
            browserDriver = new ChromeBrowserDriver();
        }
        return browserDriver.getDriver();
    }
}
