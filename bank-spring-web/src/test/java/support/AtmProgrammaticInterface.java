package support;

import nicebank.Account;
import nicebank.Teller;

import javax.annotation.Resource;

public final class AtmProgrammaticInterface implements AtmInterface {
    @Resource
    private Teller realTeller;

    private RuntimeException runtimeException;

    @Override
    public final void withdrawFrom(final Account account, final int dollars) {
        try {
            realTeller.withdrawFrom(account, dollars);
        } catch (RuntimeException e) {
            runtimeException = e;
        }
    }

    @Override
    public final void type(final int amount) {
// NOTHING TO BE DONE
    }

    @Override
    public final boolean isDisplaying(final String message) {
        // SHOULD THIS BE true OR false OR throw new NotImplementedException();?
        return true;
    }
}
