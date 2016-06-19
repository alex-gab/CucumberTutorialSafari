package com.alex.nicebank.support;

import com.alex.nicebank.Account;

public final class AccountHelper {
    private final Account account;

    public AccountHelper() {
        account = new Account(1234);
        account.saveIt();
    }

    public Account getAccount() {
        return account;
    }
}
