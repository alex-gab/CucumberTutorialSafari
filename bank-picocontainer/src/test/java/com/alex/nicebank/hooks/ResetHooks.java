package com.alex.nicebank.hooks;

import com.alex.nicebank.TransactionQueue;
import cucumber.api.java.Before;

public final class ResetHooks {
    @Before(order = 1)
    public void reset() {
        TransactionQueue.clear();
    }
}
