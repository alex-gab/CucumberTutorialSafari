package com.alex.nicebank.hooks;

import com.alex.nicebank.TransactionProcessor;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public final class BackgroundProcessHooks {
    private Thread transactionProcessorThread;

    @Before(order = 3)
    public final void startBackgroundThread() {
        transactionProcessorThread = new Thread() {
            @Override
            public final void run() {
                final TransactionProcessor processor = new TransactionProcessor();
                processor.process();
            }
        };
        transactionProcessorThread.setName("TP-Thread");
        transactionProcessorThread.start();
    }

    @After
    public final void stopBackgroundThread() {
        transactionProcessorThread.interrupt();
    }
}
