package com.alex.nicebank.hooks;

import com.alex.nicebank.BalanceStore;
import com.alex.nicebank.TransactionQueue;
import cucumber.api.java.Before;

public final class ResetHooks {
    @Before
    public void reset() {
        TransactionQueue.clear();
        BalanceStore.clear();
    }
}
