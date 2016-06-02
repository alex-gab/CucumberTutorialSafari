package com.alex.nicebank;

import com.alex.nicebank.matchers.Matchers;
import com.alex.nicebank.support.KnowsTheDomain;
import com.alex.nicebank.transforms.MoneyConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Steps {

    private final KnowsTheDomain helper;

    public Steps() {
        helper = new KnowsTheDomain();
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) final Money amount) {
        helper.getMyAccount().deposit(amount);

        assertThat(helper.getMyAccount().getBalance(), Matchers.hasAmount(amount));
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) {
        assertEquals("Incorrect amount dispensed -",
                dollars, helper.getCashSlot().contents());
    }
}
