package drivers;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxBrowserDriver extends BrowserDriver {

    public FirefoxBrowserDriver() {
        // Other potential browser setup
        //setDriverPath("");
        driver = new FirefoxDriver();
    }

    @Override
    public void setDriverPath(String driverPath) {
        System.setProperty("webdriver.firefox.driver", driverPath);
    }
}
