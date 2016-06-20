/***
 * Excerpted from "The Cucumber for Java Book",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material,
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose.
 * Visit http://www.pragmaticprogrammer.com/titles/srjcuc for more book information.
 ***/
package nicebank;

public final class CashSlotDispenser implements CashSlot {
    private int contents;
    private int available;

    @Override
    public final void load(final int dollars) {
        available = dollars;
    }

    @Override
    public final int getContents() {
        return contents;
    }

    @Override
    public final void dispense(final int requested) {
        if (available >= requested) {
            available -= requested;
            contents = requested;
        } else {
            throw new RuntimeException("Insufficient ATM founds");
        }
    }
}

