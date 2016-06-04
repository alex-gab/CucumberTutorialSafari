package com.alex.nicebank.hooks;

import com.alex.nicebank.support.KnowsTheDomain;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;

public final class WebDriverHooks {
    private final KnowsTheDomain helper;

    public WebDriverHooks(final KnowsTheDomain helper) {
        this.helper = helper;
    }

    @After
    public final void finish(final Scenario scenario) {
        try {
            final byte[] screenshot =
                    helper.getWebDriver().getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (final WebDriverException somePlatformsDontSupportScreenshots) {
            System.err.println(somePlatformsDontSupportScreenshots.getMessage());
        } finally {
            helper.getWebDriver().close();
        }
    }
}
