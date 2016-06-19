package com.alex.nicebank.support;

import com.alex.nicebank.CashSlot;

public final class KnowsTheCashSlot {
    private CashSlot cashSlot;

    public final CashSlot getCashSlot() {
        if (cashSlot == null) {
            cashSlot = new CashSlot();
        }
        return cashSlot;
    }
}
