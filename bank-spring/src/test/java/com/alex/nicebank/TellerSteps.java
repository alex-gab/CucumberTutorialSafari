package com.alex.nicebank;

import com.alex.nicebank.config.TestConfiguration;
import com.alex.nicebank.support.KnowsTheDomain;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestConfiguration.class)
public final class TellerSteps {
    private final KnowsTheDomain helper;

    @Autowired
    public TellerSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int dollars) {
        helper.getTeller().withdrawFrom(helper.getMyAccount(), dollars);
    }
}
