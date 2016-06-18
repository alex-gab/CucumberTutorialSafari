package com.alex.nicebank;

import org.javalite.activejdbc.Base;

public final class TransactionProcessor {
    private TransactionQueue queue = new TransactionQueue();

    public void process() {
        boolean wasInterrupted = false;
        do {
            if (!Base.hasConnection()) {
                Base.open(
                        "com.mysql.jdbc.Driver",
                        "jdbc:mysql://localhost/iCucumber?useSSL=false",
                        "teller", "cucumber");
            }

            String message = queue.read();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                wasInterrupted = true;
            }

            if (!wasInterrupted && message.length() > 0) {
                final String[] parts = message.split(",");
                final Account account = Account.findFirst("number = ?", parts[1]);
                Money transactionAmount = new Money(parts[0]);

                if (isCreditTransaction(message)) {
                    account.setBalance(account.getBalance().add(transactionAmount));
                } else {
                    account.setBalance(account.getBalance().minus(transactionAmount));
                }
            }
        } while (!wasInterrupted);
    }

    private boolean isCreditTransaction(String message) {
        return !message.startsWith("-");
    }
}
