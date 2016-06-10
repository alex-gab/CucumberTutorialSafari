package com.alex.nicebank;

import java.util.Objects;
import java.util.regex.Pattern;

import static java.lang.String.format;

public class Money {
    private final int dollars;
    private final int cents;

    Money(final String amount) {
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

    public final Money add(final Money amount) {
        int newCents = cents + amount.cents();
        int newDollars = dollars + amount.dollars();

        if (newCents >= 100) {
            newCents -= 100;
            newDollars++;
        }

        return new Money(newDollars, newCents);
    }

    public final Money minus(final Money amount) {
        int newCents = cents - amount.cents();
        int newDollars = dollars - amount.dollars();

        if (newCents < 0) {
            newCents += 100;
            newDollars--;
        }

        return new Money(newDollars, newCents);
    }

    public final int dollars() {
        return dollars;
    }

    public final int cents() {
        return cents;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Money money = (Money) o;
        return dollars == money.dollars &&
                cents == money.cents;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(dollars, cents);
    }

    @Override
    public String toString() {
        return format("$%01d.%02d", this.dollars(), this.cents());
    }
}
