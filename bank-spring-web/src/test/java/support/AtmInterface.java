package support;

import nicebank.Teller;

public interface AtmInterface extends Teller {
    void type(final int amount);

    boolean isDisplaying(final String message);
}
