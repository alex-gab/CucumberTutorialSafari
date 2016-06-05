package com.alex.nicebank;

import com.alex.nicebank.support.KnowsTheDomain;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public final class CashSlotSteps {
    private final KnowsTheDomain helper;

    public CashSlotSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(helper.getWebDriver(), 1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("withdrawBody")));

        assertEquals("Incorrect amount dispensed -",
                dollars, helper.getCashSlot().contents());
    }
}
