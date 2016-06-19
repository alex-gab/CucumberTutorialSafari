package com.alex.nicebank;

import com.alex.nicebank.support.KnowsTheAccount;
import com.alex.nicebank.support.KnowsTheTeller;
import cucumber.api.java.en.When;

public final class TellerSteps {
    private final KnowsTheTeller tellerHelper;
    private final KnowsTheAccount accountHelper;

    public TellerSteps(final KnowsTheTeller tellerHelper, final KnowsTheAccount accountHelper) {
        this.tellerHelper = tellerHelper;
        this.accountHelper = accountHelper;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) {
        tellerHelper.getTeller().withdrawFrom(accountHelper.getMyAccount(), dollars);
    }
}
