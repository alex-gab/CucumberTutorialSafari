package com.alex;

import java.util.regex.Pattern;

public class Money {
    private final int dollars;
    private final int cents;

    public Money(String amount) {
        Pattern pattern = Pattern.compile("^[^\\d]*([\\d]+)\\.([\\d][\\d])$");
        final java.util.regex.Matcher matcher = pattern.matcher(amount);
        matcher.find();
        dollars = Integer.parseInt(matcher.group(1));
        cents = Integer.parseInt(matcher.group(2));
    }

    public Money(final int dollars, final int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public Money add(Money amount) {
        final int sumCents = this.cents + amount.cents;
        final int newCents = sumCents % 100;
        final int newDollars = this.dollars + amount.dollars + sumCents / 100;
        return new Money(newDollars, newCents);
    }


    public int dollars() {
        return dollars;
    }

    public int cents() {
        return cents;
    }

    @Override
    public String toString() {
        return "Money{" +
                "dollars=" + dollars +
                ", cents=" + cents +
                '}';
    }
}
