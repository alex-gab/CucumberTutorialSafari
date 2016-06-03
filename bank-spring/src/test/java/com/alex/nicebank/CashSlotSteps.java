package com.alex.nicebank;

import com.alex.nicebank.config.TestConfiguration;
import com.alex.nicebank.support.KnowsTheDomain;
import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = TestConfiguration.class)
public final class CashSlotSteps {
    private final KnowsTheDomain helper;

    @Autowired
    public CashSlotSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) {
        assertEquals("Incorrect amount dispensed -",
                dollars, helper.getCashSlot().contents());
    }
}
