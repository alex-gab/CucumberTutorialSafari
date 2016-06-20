/***
 * Excerpted from "The Cucumber for Java Book",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/srjcuc for more book information.
 ***/
package nicebank;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doThrow;

public final class CashSlotSteps {
    @Autowired
    private CashSlot cashSlot;

    @But("^the cash slot has developed a fault$")
    public void theCashSlotHasDevelopedAFault() {
        doThrow(new RuntimeException("Out of order")).when(cashSlot).dispense(anyInt());
    }

    @Given("^\\$(\\d+) should be dispensed$")
    public void $ShouldBeDispensed(int dollars) throws Throwable {
        Assert.assertEquals("Incorrect amount dispensed -", dollars,
                cashSlot.getContents());
    }

    @And("^the ATM contains \\$(\\d+)$")
    public void theATMContains$(final int dollars) {
        cashSlot.load(dollars);
    }
}
