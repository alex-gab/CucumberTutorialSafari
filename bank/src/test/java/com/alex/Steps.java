package com.alex;

import com.alex.transforms.MoneyConverter;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static com.alex.matchers.Matchers.hasAmount;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class Steps {
    private static final class Account {
        private Money balance = new Money("0.00");

        public final void deposit(final Money amount) {
            balance = balance.add(amount);
        }

        public final Money getBalance() {
            return balance;
        }
    }

    private static final class Teller {
        private final CashSlot cashSlot;

        private Teller(final CashSlot cashSlot) {
            this.cashSlot = cashSlot;
        }

        public void withdrawFrom(final Account account, final int amount) {
            cashSlot.dispense(amount);
        }
    }

    private static final class CashSlot {
        private int contents;

        public final int contents() {
            return contents;
        }

        public final void dispense(final int amount) {
            contents = amount;
        }
    }

    private static final class KnowsTheDomain {
        private Account myAccount;
        private CashSlot cashSlot;
        private Teller teller;

        public final Account getMyAccount() {
            if (myAccount == null) {
                myAccount = new Account();
            }
            return myAccount;
        }

        public final CashSlot getCashSlot() {
            if (cashSlot == null) {
                cashSlot = new CashSlot();
            }
            return cashSlot;
        }

        public final Teller getTeller() {
            if (teller == null) {
                teller = new Teller(getCashSlot());
            }
            return teller;
        }
    }

    private final KnowsTheDomain helper;

    public Steps() {
        helper = new KnowsTheDomain();
    }

    @Given("^I have deposited (\\$\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(@Transform(MoneyConverter.class) final Money amount) {
        helper.getMyAccount().deposit(amount);

        assertThat(helper.getMyAccount().getBalance(), hasAmount(amount));
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
