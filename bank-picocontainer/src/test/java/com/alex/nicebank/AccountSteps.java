package com.alex.nicebank;

import com.alex.nicebank.support.AccountHelper;
import com.alex.nicebank.transforms.MoneyConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static com.alex.nicebank.matchers.Matchers.hasAmount;
import static org.junit.Assert.assertThat;

public final class AccountSteps {
    private final AccountHelper accountHelper;

    public AccountSteps(AccountHelper accountHelper) {
        this.accountHelper = accountHelper;
    }

    @Given("^my account has been credited with (\\$\\d+\\.\\d+)$")
    public void myAccountHasBeenCreditedWith(@Transform(MoneyConverter.class) final Money amount) {
        accountHelper.getAccount().credit(amount);
    }

    @Then("^the balance in my account should be (\\$\\d+\\.\\d+)$")
    public void theBalanceInMyAccountShouldBe$(@Transform(MoneyConverter.class) final Money amount) throws InterruptedException {
        int remaining = 3000;
        final int poolInterval = 100;
        Money actualBalance = accountHelper.getAccount().getBalance();
        while (remaining > 0 && !actualBalance.equals(amount)) {
            Thread.sleep(poolInterval);
            remaining -= poolInterval;
            actualBalance = accountHelper.getAccount().getBalance();

        }
        assertThat(accountHelper.getAccount().getBalance(), hasAmount(amount));
    }

}
