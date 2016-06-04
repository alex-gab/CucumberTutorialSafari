package com.alex.nicebank;

public final class Teller {
    private final CashSlot cashSlot;

    public Teller(final CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    public void withdrawFrom(final Account account, final int dollars) {
        account.debit(dollars);
        cashSlot.dispense(dollars);
    }
}
