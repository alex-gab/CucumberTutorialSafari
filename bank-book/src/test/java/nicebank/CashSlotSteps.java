/***
 * Excerpted from "The Cucumber for Java Book",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/srjcuc for more book information.
***/
package nicebank;

import cucumber.api.java.en.Given;
import org.junit.Assert;
import support.KnowsTheDomain;

public class CashSlotSteps {

  KnowsTheDomain helper;

  public CashSlotSteps(KnowsTheDomain helper) {
      this.helper = helper;
  }
      
  @Given("^\\$(\\d+) should be dispensed$")
  public void $ShouldBeDispensed(int dollars) throws Throwable {
    Assert.assertEquals("Incorrect amount dispensed -", dollars, 
                                    helper.getCashSlot().getContents());
  }
}