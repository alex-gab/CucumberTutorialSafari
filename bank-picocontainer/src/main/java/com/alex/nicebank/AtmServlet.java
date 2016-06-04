package com.alex.nicebank;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_OK;

public final class AtmServlet extends HttpServlet {
    @Override
    protected final void doGet(final HttpServletRequest req,
                               final HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.setStatus(SC_OK);
        resp.getWriter().println("<html><head><title>Nice Bank ATM</title></head>"
                + "<body><h1>Welcome to our nice bank!</h1></body></html>");
    }
}
