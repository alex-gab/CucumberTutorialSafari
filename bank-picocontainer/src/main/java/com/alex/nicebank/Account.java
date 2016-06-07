package com.alex.nicebank;

public final class Account {
    private final TransactionQueue queue = new TransactionQueue();

    final void credit(final Money amount) {
        queue.write("+" + amount.toString());
    }

    final void debit(final int dollars) {
        final Money amount = new Money(dollars, 0);
        queue.write("-" + amount.toString());
    }

    final Money getBalance() {
        return BalanceStore.getBalance();
    }
}
