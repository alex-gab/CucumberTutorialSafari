package config;

import org.springframework.context.annotation.*;
import support.*;

@Configuration
public class AppConfig {
    @Bean(name = "teller")
    @Scope("cucumber-glue")
    @Lazy
    @Conditional(BypassTellerUi.class)
    public AtmInterface atmProgrammaticInterface() {
        return new AtmProgrammaticInterface();
    }

    @Bean(name = "teller")
    @Scope("cucumber-glue")
    @Lazy
    @Conditional(UseTellerUi.class)
    public AtmInterface atmUserInterface() {
        return new AtmUserInterface();
    }

    @Bean
    public Object newObject() {
        return new Object();
    }
}
