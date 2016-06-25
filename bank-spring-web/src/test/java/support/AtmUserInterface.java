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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
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
        for (int i = 0; i < amountString.length(); ++i) {
            input.sendKeys(convertToKey(amountString.charAt(i)));
        }
//        ask("Ready to continue");
    }

    public final boolean isDisplaying(final String message) {
        final By locator = By.xpath("//*[contains(text(),'" + message + "')]");

        WebDriverWait wait = new WebDriverWait(webDriver, 2, 30);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        final List<WebElement> elements = webDriver.findElements(locator);
        return elements.size() > 0;
    }

    private CharSequence convertToKey(char digit) {
        switch (digit) {
            case '0':
                return Keys.NUMPAD0;
            case '1':
                return Keys.NUMPAD1;
            case '2':
                return Keys.NUMPAD2;
            case '3':
                return Keys.NUMPAD3;
            case '4':
                return Keys.NUMPAD4;
            case '5':
                return Keys.NUMPAD5;
            case '6':
                return Keys.NUMPAD6;
            case '7':
                return Keys.NUMPAD7;
            case '8':
                return Keys.NUMPAD8;
            case '9':
                return Keys.NUMPAD9;
            default:
                throw new RuntimeException("Invalid keypress in test. Character to be entered is not a digit");
        }
    }

    private void ask(String question) {
        JOptionPane.showMessageDialog(
                null,
                question,
                "Ask for response",
                JOptionPane.PLAIN_MESSAGE);
    }
}
