package com.anam.elibrary.config;

import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LayoutConfigure {
    @Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }
}
