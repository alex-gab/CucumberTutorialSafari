package com.alex.nicebank.support;

import com.alex.nicebank.Account;
import com.alex.nicebank.CashSlot;
import com.alex.nicebank.Teller;

public final class KnowsTheDomain {
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
