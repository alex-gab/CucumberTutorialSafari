package com.alex.nicebank.transforms;

import com.alex.nicebank.Money;
import cucumber.api.Transformer;

import static java.lang.Integer.parseInt;

public final class MoneyConverter extends Transformer<Money> {
    @Override
    public Money transform(final String amount) {
        final String[] parts = amount.substring(1).split("\\.");
        final int dollars = parseInt(parts[0]);
        final int cents = parseInt(parts[1]);
        return new Money(dollars, cents);
    }
}
