package com.alex.nicebank.hooks;

import com.alex.nicebank.support.MyWebDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

public final class WebDriverHooks {
    private final MyWebDriver webDriver;

    public WebDriverHooks(final MyWebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @After
    public final void finish(final Scenario scenario) {
        try {
            final byte[] screenshot = webDriver.getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (final WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        } finally {
            webDriver.close();
        }
    }
}
