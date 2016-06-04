package com.alex.nicebank;

public final class AutomatedTeller implements Teller {
    private final CashSlot cashSlot;

    public AutomatedTeller(final CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @Override
    public void withdrawFrom(final Account account, final int dollars) {
        account.debit(dollars);
        cashSlot.dispense(dollars);
    }
}
