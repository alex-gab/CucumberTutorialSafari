package com.alex.nicebank;

public final class Account {
    private Money balance = new Money("0.00");

    final void credit(final Money amount) {
        balance = balance.add(amount);
    }

    final void debit(final int amount) {
        balance = balance.minus(new Money(amount, 0));
    }

    final Money getBalance() {
        return balance;
    }
}
