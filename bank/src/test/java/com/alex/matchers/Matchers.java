package com.alex.matchers;

import com.alex.Steps;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;

public final class Matchers {
    public static Matcher<Steps.Money> hasAmount(final Steps.Money amount) {
        return new TypeSafeDiagnosingMatcher<Steps.Money>() {
            @Override
            protected boolean matchesSafely(final Steps.Money actualMoney, final Description mismatchDescription) {
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
