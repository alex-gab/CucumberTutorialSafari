package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * <p>
 * Example of a WebDriver implementation that has delegates all methods to a static instance (realDriver) that is only
 * created once for the duration of the JVM. The realDriver is automatically closed when the JVM exits. This makes
 * scenarios a lot faster since opening and closing a browser for each scenario is pretty slow.
 * To prevent browser state from leaking between scenarios, cookies are automatically deleted before every scenario.
 * </p>
 * <p>
 * A new instance of SharedDriver is created for each Scenario and passed to yor Stepdef classes via Dependency Injection
 * </p>
 * <p>
 * As a bonus, screenshots are embedded into the report for each scenario. (This only works
 * if you're also using the HTML formatter).
 * </p>
 * <p>
 * A new instance of the SharedDriver is created for each Scenario and then passed to the Step Definition classes'
 * constructor. They all receive a reference to the same instance. However, the realDriver is the same instance throughout
 * the life of the JVM.
 * </p>
 */
public class SharedDriver extends EventFiringWebDriver {
    private final WebDriver realDriver;
    private final Thread closeThread = new Thread("closeThread") {
        @Override
        public void run() {
            realDriver.close();
        }
    };

    public SharedDriver(final WebDriver realDriver) {
        super(realDriver);
        this.realDriver = realDriver;
        Runtime.getRuntime().addShutdownHook(closeThread);
    }

    @Override
    public void close() {
        if (Thread.currentThread() != closeThread) {
            throw new UnsupportedOperationException("You shouldn't close this WebDriver. It's shared and will close when the JVM exits.");
        }
        super.close();
    }
}
