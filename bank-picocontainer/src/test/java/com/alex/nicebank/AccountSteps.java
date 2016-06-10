package com.alex.nicebank;

import com.alex.nicebank.support.KnowsTheDomain;
import com.alex.nicebank.transforms.MoneyConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static com.alex.nicebank.matchers.Matchers.hasAmount;
import static org.junit.Assert.assertThat;

public final class AccountSteps {
    private final KnowsTheDomain helper;

    public AccountSteps(KnowsTheDomain helper) {
        this.helper = helper;
    }

    @Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
    public void myAccountHasBeenCreditedWith(@Transform(MoneyConverter.class) final Money amount) {
        helper.getMyAccount().credit(amount);
    }

    @Then("^the balance in my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceInMyAccountShouldBe$(@Transform(MoneyConverter.class) final Money amount) throws InterruptedException {
        int remaining = 3000;
        final int poolInterval = 100;
        Money actualBalance = helper.getMyAccount().getBalance();
        while (remaining > 0 && !actualBalance.equals(amount)) {
            Thread.sleep(poolInterval);
            remaining -= poolInterval;
            actualBalance = helper.getMyAccount().getBalance();

        }
        assertThat(helper.getMyAccount().getBalance(), hasAmount(amount));
    }

}
