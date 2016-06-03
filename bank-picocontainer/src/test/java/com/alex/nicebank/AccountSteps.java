package com.alex.nicebank;

import com.alex.nicebank.matchers.Matchers;
import com.alex.nicebank.support.KnowsTheDomain;
import com.alex.nicebank.transforms.MoneyConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;

import static org.junit.Assert.assertThat;

public final class AccountSteps {
    private final KnowsTheDomain helper;

    public AccountSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) final Money amount) {
        helper.getMyAccount().deposit(amount);

        assertThat(helper.getMyAccount().getBalance(), Matchers.hasAmount(amount));
    }

}
