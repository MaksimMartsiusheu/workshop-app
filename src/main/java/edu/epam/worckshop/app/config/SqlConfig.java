package edu.epam.worckshop.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sql-queries.properties")
public class SqlConfig {
}
