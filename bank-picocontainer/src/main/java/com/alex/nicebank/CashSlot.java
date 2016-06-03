package com.alex.nicebank;

public final class CashSlot {
    private int contents;

    final int contents() {
        return contents;
    }

    final void dispense(final int amount) {
        contents = amount;
    }
}
