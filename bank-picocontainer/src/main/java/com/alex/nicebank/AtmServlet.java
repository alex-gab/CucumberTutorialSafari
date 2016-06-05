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
        resp.getWriter().println(
                "<html><head><title>ATM</title></head>" +
                        "<body><form action=\"/withdraw\" method=\"post\">" +
                        "<label for=\"amount\">Amount</label>" +
                        "<input type=\"text\" id=\"amount\" name=\"amount\">" +
                        "<button type=\"submit\" id=\"withdraw\">Withdraw</button>" +
                        "</form></body></html>");
    }
}
