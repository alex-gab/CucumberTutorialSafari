package com.alex.nicebank;

import com.alex.nicebank.support.AccountHelper;
import com.alex.nicebank.support.AtmUserInterface;
import cucumber.api.java.en.When;

public final class TellerSteps {
    private final AtmUserInterface teller;
    private final AccountHelper accountHelper;

    public TellerSteps(final AtmUserInterface teller, final AccountHelper accountHelper) {
        this.teller = teller;
        this.accountHelper = accountHelper;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) {
        teller.withdrawFrom(accountHelper.getAccount(), dollars);
    }
}
