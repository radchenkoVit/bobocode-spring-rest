package com.bobocode.radchenko.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.bobocode.radchenko.web")
@EnableWebMvc
public class WebConfig {
}
