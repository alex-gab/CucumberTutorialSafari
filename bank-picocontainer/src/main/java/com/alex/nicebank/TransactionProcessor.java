package com.alex.nicebank;

public final class TransactionProcessor {
    private TransactionQueue queue = new TransactionQueue();

    public void process() {
        boolean wasInterrupted = false;
        do {
            String message = queue.read();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                wasInterrupted = true;
            }

            if (!wasInterrupted && message.length() > 0) {
                Money balance = BalanceStore.getBalance();
                Money transactionAmount = new Money(message);

                if (isCreditTransaction(message)) {
                    BalanceStore.setBalance(balance.add(transactionAmount));
                } else {
                    BalanceStore.setBalance(balance.minus(transactionAmount));
                }
            }
        } while (!wasInterrupted);
    }

    private boolean isCreditTransaction(String message) {
        return !message.startsWith("-");
    }
}
