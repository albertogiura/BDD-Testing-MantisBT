package io.cucumber.mantis.drivers;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeBrowserDriver extends BrowserDriver {

    public ChromeBrowserDriver() {
        // Other potential browser setup
        //setDriverPath("");
        driver = new ChromeDriver();
    }

    @Override
    public void setDriverPath(String driverPath) {
        System.setProperty("webdriver.chrome.driver", driverPath);
    }
}
