package com.bobocode.radchenko.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(basePackages = "com.bobocode.radchenko",
        excludeFilters = {@ComponentScan.Filter(classes = WebConfig.class, type = FilterType.ANNOTATION),
                          @ComponentScan.Filter(classes = RootConfig.class, type = FilterType.ANNOTATION)
        })
public class RootConfig {
}
