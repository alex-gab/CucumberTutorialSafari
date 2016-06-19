package com.alex.nicebank.hooks;

import com.alex.nicebank.Account;
import com.alex.nicebank.TransactionQueue;
import cucumber.api.java.Before;
import org.javalite.activejdbc.Base;

public final class ResetHooks {
    @Before(order = 1)
    public void reset() {
        if (!Base.hasConnection()) {
            Base.open(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost/iCucumber?useSSL=false",
                    "teller",
                    "cucumber");
        }
        Account.deleteAll();
        TransactionQueue.clear();
    }
}
