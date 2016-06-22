package nicebank;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class ValidationServlet extends HttpServlet {
    private final CashSlot cashSlot;

    public ValidationServlet(final CashSlot cashSlot) {
        this.cashSlot = cashSlot;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);

        int amount = Integer.parseInt(request.getParameter("amount"));

        if (cashSlot.canDispense(amount)) {
            response.getWriter().println("{\"content\":\"\"}");
        } else {
            response.getWriter().println(
                    "{\"content\":\"Insufficient ATM funds\"}");
        }
    }
}
