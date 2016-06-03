package com.alex.nicebank.config;

import com.alex.nicebank.support.KnowsTheDomain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfiguration {

    @Bean
    public KnowsTheDomain helper() {
        return new KnowsTheDomain();
    }
}
