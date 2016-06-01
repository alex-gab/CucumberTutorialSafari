package com.alex;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.regex.Pattern;

import static com.alex.matchers.Matchers.hasAmount;
import static org.junit.Assert.assertThat;

public class Steps {
    @Given("^I have deposited \\$(\\d+\\.\\d+) in my account$")
    public void iHaveDeposited$InMyAccount(Money amount) throws Throwable {
        Account account = new Account();
        account.deposit(amount);

        assertThat(account.getBalance(), hasAmount(amount));
    }

    @When("^I request \\$(\\d+)$")
    public void iRequest$(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    private static class Account {
        private Money balance = new Money("0.00");

        public void deposit(Money amount) {
            balance = balance.add(amount);
        }

        public Money getBalance() {
            return balance;
        }
    }

    public static class Money {
        private final int dollars;
        private final int cents;

        public Money(String amount) {
            Pattern pattern = Pattern.compile("^[^\\d]*([\\d]+)\\.([\\d][\\d])$");
            final java.util.regex.Matcher matcher = pattern.matcher(amount);
            matcher.find();
            dollars = Integer.parseInt(matcher.group(1));
            cents = Integer.parseInt(matcher.group(2));
        }

        public Money(final int dollars, final int cents) {
            this.dollars = dollars;
            this.cents = cents;
        }

        public Money add(Money amount) {
            final int sumCents = this.cents + amount.cents;
            final int newCents = sumCents % 100;
            final int newDollars = this.dollars + amount.dollars + sumCents / 100;
            return new Money(newDollars, newCents);
        }


        public int dollars() {
            return dollars;
        }

        public int cents() {
            return cents;
        }

        @Override
        public String toString() {
            return "Money{" +
                    "dollars=" + dollars +
                    ", cents=" + cents +
                    '}';
        }
    }
}
