package com.alex.nicebank;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class WithdrawalServlet extends HttpServlet {
    private final CashSlot cashSlot;
    private final Account account;

    public WithdrawalServlet(final CashSlot cashSlot, final Account account) {
        this.cashSlot = cashSlot;
        this.account = account;
    }

    @Override
    protected final void doPost(final HttpServletRequest req,
                                final HttpServletResponse resp) throws IOException {
        final AutomatedTeller teller = new AutomatedTeller(cashSlot);
        final int amount = Integer.parseInt(req.getParameter("amount"));
        teller.withdrawFrom(account, amount);

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(
                "<html><head><title>ATM</title></head>" +
                        "<body id=\"withdrawBody\">Please take your $" + amount + "</body></html>");
    }
}
