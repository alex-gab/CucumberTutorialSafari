package com.alex.nicebank.support;

import com.alex.nicebank.Account;
import org.javalite.activejdbc.Base;

public final class KnowsTheAccount {
    private Account myAccount;

    public KnowsTheAccount() {
        if (!Base.hasConnection()) {
            Base.open(
                    "com.mysql.jdbc.Driver",
                    "jdbc:mysql://localhost/iCucumber?useSSL=false",
                    "teller",
                    "cucumber");
        }
        Account.deleteAll();
    }

    public final Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account(1234);
            myAccount.saveIt();
        }
        return myAccount;
    }
}
