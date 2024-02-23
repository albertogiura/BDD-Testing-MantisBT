package drivers;

import org.openqa.selenium.WebDriver;

public abstract class BrowserDriver {
    protected WebDriver driver = null;

    public abstract void setDriverPath(String driverPath);

    protected WebDriver getDriver() {
        return driver;
    }
}
