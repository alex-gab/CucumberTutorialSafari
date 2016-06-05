package com.alex.nicebank;

import com.alex.nicebank.support.KnowsTheDomain;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

public final class CashSlotSteps {
    private final KnowsTheDomain helper;

    public CashSlotSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) {
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        assertEquals("Incorrect amount dispensed -",
                dollars, helper.getCashSlot().contents());
    }
}
