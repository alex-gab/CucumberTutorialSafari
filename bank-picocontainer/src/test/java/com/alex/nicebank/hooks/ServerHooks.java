package com.alex.nicebank.hooks;

import com.alex.nicebank.AtmServer;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public final class ServerHooks {
    public static final int PORT = 8887;

    private final AtmServer server = new AtmServer(PORT);

    @Before
    public void startServer() throws Exception {
        server.start();
        System.out.printf("server is started and listening at port: %d", PORT);
    }

    @After
    public void stopServer() throws Exception {
        server.stop();
        System.out.println("Server is stopped.");
    }
}
