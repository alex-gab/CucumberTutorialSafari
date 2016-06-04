package com.alex.nicebank.support;

import com.alex.nicebank.Account;
import com.alex.nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import static com.alex.nicebank.hooks.ServerHooks.PORT;
import static java.lang.String.format;

public final class AtmUserInterface implements Teller {
    private final EventFiringWebDriver webDriver;

    public AtmUserInterface(final KnowsTheDomain helper) {
        this.webDriver = helper.getWebDriver();
    }

    @Override
    public void withdrawFrom(final Account account, final int dollars) {
        webDriver.get(format("http://localhost:%d", PORT));
        webDriver.findElement(By.id("Amount")).sendKeys(String.valueOf(dollars));
        webDriver.findElement(By.id("Withdraw")).click();
    }
}
