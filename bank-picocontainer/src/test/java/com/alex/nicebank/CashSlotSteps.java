package com.alex.nicebank;

import com.alex.nicebank.support.KnowsTheCashSlot;
import com.alex.nicebank.support.MyWebDriver;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public final class CashSlotSteps {
    private final KnowsTheCashSlot cashSlotHelper;
    private final MyWebDriver webDriver;

    public CashSlotSteps(final KnowsTheCashSlot cashSlotHelper, final MyWebDriver webDriver) {
        this.cashSlotHelper = cashSlotHelper;
        this.webDriver = webDriver;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(webDriver, 1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("withdrawBody")));

        assertEquals("Incorrect amount dispensed -",
                dollars, cashSlotHelper.getCashSlot().contents());
    }
}
