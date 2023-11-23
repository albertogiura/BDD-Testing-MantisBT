package io.cucumber.mantis.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver = null;

    public void getURL(String url) {
        driver.get(url);
    }
}
