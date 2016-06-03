package com.alex.nicebank;

import com.alex.nicebank.support.KnowsTheDomain;
import cucumber.api.java.en.When;

public final class TellerSteps {
    private final KnowsTheDomain helper;

    public TellerSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
    }
}
