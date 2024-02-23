package concordion.mantis.util;

import concordion.mantis.drivers.DriverFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

// Singleton pattern
public class DriverLocator {

    private static WebDriver instance = null;

    private DriverLocator() {}

    public static void createDriverInstance() {
        String browser = System.getProperty("browser", "chrome");
        instance = DriverFactory.initBrowserDriver(browser);
        instance.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public static WebDriver getDriverInstance() {
        if (instance == null) {
            createDriverInstance();
        }
        return instance;
    }
}
