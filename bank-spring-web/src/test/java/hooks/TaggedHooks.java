package hooks;

import cucumber.api.java.Before;
import support.AtmInterfaceFactory;

public final class TaggedHooks {
    @Before("@bypass_teller_ui")
    public final void bypassTellerUi() {
        AtmInterfaceFactory.bypassTellerUI();
    }
}
