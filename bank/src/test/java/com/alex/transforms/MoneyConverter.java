package com.alex.transforms;

import com.alex.Money;
import cucumber.api.Transformer;

import static java.lang.Integer.parseInt;

public class MoneyConverter extends Transformer<Money> {
    @Override
    public Money transform(String amount) {
        final String[] parts = amount.substring(1).split("\\.");
        final int dollars = parseInt(parts[0]);
        final int cents = parseInt(parts[1]);
        return new Money(dollars, cents);
    }
}
