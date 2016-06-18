package com.alex.nicebank;

import org.javalite.activejdbc.Model;

public final class Account extends Model {
    private final TransactionQueue queue = new TransactionQueue();

    public Account(final int number) {
        setInteger("number", number);
        setString("balance", "0.00");
    }

    public Account() {

    }

    final void credit(final Money amount) {
        queue.write("+" + amount.toString() + "," + getNumber());
    }

    final void debit(final int dollars) {
        final Money amount = new Money(dollars, 0);
        queue.write("-" + amount.toString() + "," + getNumber());
    }

    public final int getNumber() {
        return getInteger("number");
    }

    public final Money getBalance() {
        refresh();
        return new Money(getString("balance"));
    }

    public final void setBalance(final Money amount) {
        setString("balance", amount.toString().substring(1));
        saveIt();
    }
}
