/***
 * Excerpted from "The Cucumber for Java Book",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/srjcuc for more book information.
 ***/
package nicebank;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import support.AtmInterface;

import static org.junit.Assert.assertTrue;

public class TellerSteps {

    @Autowired
    private Account account;

    @Autowired
    private AtmInterface teller;

    @When("^I type \\$(\\d+)$")
    public void iType$(int amount) {
        teller.type(amount);
    }

    @When("^I request some of my money$")
    public void iRequestSomeOfMyMoney() {
        iWithdraw$(10);
    }

    @When("^I withdraw \\$(\\d+)$")
    public void iWithdraw$(int amount) {
        teller.withdrawFrom(account, amount);
    }

    @Then("^I should see an out-of-order message$")
    public void iShouldSeeAnOutOfOrderMessage() {
        assertTrue("Expected error message not displayed", teller.isDisplaying("Out of order"));
    }

    @Then("^I should see an ask-for-less-money message$")
    public void iShouldSeeAnAskForLessMoneyMessage() {
        assertTrue("Expected error message not displayed", teller.isDisplaying("Insufficient ATM funds"));
    }
}