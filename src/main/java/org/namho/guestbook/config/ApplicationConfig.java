package org.namho.guestbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = {"org.namho.guestbook.dao", "org.namho.guestbook.service"})
@Import({ DBConfig.class })
public class ApplicationConfig {
}
