/***
 * Excerpted from "The Cucumber for Java Book",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/srjcuc for more book information.
 ***/
package support;

import nicebank.Account;
import nicebank.Teller;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AtmUserInterface implements Teller {
    @Autowired
    private EventFiringWebDriver webDriver;

    @Override
    public void withdrawFrom(Account account, int amount) {
        webDriver.get("http://localhost:" + hooks.ServerHooks.PORT);
        webDriver.findElement(By.id("amount")).sendKeys(String.valueOf(amount));
        webDriver.findElement(By.id("withdraw")).click();
    }

    public final void type(final int amount) {
        webDriver.get("http://localhost:" + hooks.ServerHooks.PORT);
        final WebElement input = webDriver.findElement(By.id("amount"));
        final String amountString = String.valueOf(amount);
        input.sendKeys(amountString);
    }

    public final boolean isDisplaying(final String message) {
        final List<WebElement> elements = webDriver.findElements(By.xpath("//*[contains(text(),'" + message + "')]"));
        return elements.size() > 0;
    }
}
