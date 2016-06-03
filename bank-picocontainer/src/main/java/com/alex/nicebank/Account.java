package com.alex.nicebank;

public final class Account {
    private Money balance = new Money("0.00");

    final void deposit(final Money amount) {
        balance = balance.add(amount);
    }

    final Money getBalance() {
        return balance;
    }
}
