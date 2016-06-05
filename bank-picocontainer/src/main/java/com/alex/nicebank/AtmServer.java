package com.alex.nicebank;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import static org.eclipse.jetty.servlet.ServletContextHandler.SESSIONS;

public final class AtmServer {
    private final Server server;

    public AtmServer(final int port, final CashSlot cashSlot, final Account account) {
        server = new Server(port);

        final ServletContextHandler context = new ServletContextHandler(SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        context.addServlet(new ServletHolder(new WithdrawalServlet(cashSlot, account)), "/withdraw");
        context.addServlet(new ServletHolder(new AtmServlet()), "/*");
    }

    public void start() throws Exception {
        server.start();
        System.out.printf("Listening on: %s.\n", server.getURI());
    }

    public void stop() throws Exception {
        server.stop();
    }

    public static void main(String[] args) throws Exception {
        new AtmServer(9988, new CashSlot(), new Account()).start();
    }
}
