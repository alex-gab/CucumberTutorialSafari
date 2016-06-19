package com.alex.nicebank.support;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public final class MyWebDriver extends EventFiringWebDriver {
    public MyWebDriver() {
        super(new ChromeDriver());
    }
}
