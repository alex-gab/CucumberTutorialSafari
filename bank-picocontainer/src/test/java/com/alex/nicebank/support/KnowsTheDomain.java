package com.alex.nicebank.support;

import com.alex.nicebank.Account;
import com.alex.nicebank.CashSlot;
import com.alex.nicebank.Teller;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public final class KnowsTheDomain {
    private Account myAccount;
    private CashSlot cashSlot;
    private Teller teller;
    private EventFiringWebDriver webDriver;

    public final Account getMyAccount() {
        if (myAccount == null) {
            myAccount = new Account();
        }
        return myAccount;
    }

    public final CashSlot getCashSlot() {
        if (cashSlot == null) {
            cashSlot = new CashSlot();
        }
        return cashSlot;
    }

    public final Teller getTeller() {
        if (teller == null) {
            teller = new AtmUserInterface(this);
        }
        return teller;
    }

    public final EventFiringWebDriver getWebDriver() {
        if (webDriver == null) {
            webDriver = new EventFiringWebDriver(new ChromeDriver());
        }
        return webDriver;
    }
}
