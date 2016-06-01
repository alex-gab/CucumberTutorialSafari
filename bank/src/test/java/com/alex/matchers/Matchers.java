package com.alex.matchers;

import com.alex.Money;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public final class Matchers {
    public static Matcher<Money> hasAmount(final Money amount) {
        return new TypeSafeDiagnosingMatcher<Money>() {
            @Override
            protected boolean matchesSafely(final Money actualMoney, final Description mismatchDescription) {
                mismatchDescription.appendText("was: ").appendValue(actualMoney);
                return actualMoney.dollars() == amount.dollars() && actualMoney.cents() == amount.cents();
            }

            @Override
            public void describeTo(Description description) {
                description.appendValue(amount);
            }
        };
    }
}
