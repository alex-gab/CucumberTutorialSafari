package com.alex.nicebank.hooks;

import com.alex.nicebank.AtmServer;
import com.alex.nicebank.support.KnowsTheAccount;
import com.alex.nicebank.support.KnowsTheCashSlot;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public final class ServerHooks {
    public static final int PORT = 8097;

    private final AtmServer server;

    public ServerHooks(final KnowsTheCashSlot cashSlotHelper,
                       final KnowsTheAccount accountHelper) {
        server = new AtmServer(
                PORT,
                cashSlotHelper.getCashSlot(),
                accountHelper.getMyAccount());
    }

    @Before(order = 2)
    public void startServer() throws Exception {
        server.start();
        System.out.printf("server is started and listening at port: %d.\n", PORT);
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
        System.out.println("Server is stopped.");
    }
}
