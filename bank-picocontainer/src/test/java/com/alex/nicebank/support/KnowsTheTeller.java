package com.alex.nicebank.support;

import com.alex.nicebank.Teller;

public final class KnowsTheTeller {
    private final Teller teller;

    public KnowsTheTeller(AtmUserInterface teller) {
        this.teller = teller;
    }

    public final Teller getTeller() {
        return teller;
    }
}
