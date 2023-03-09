package com.nb.command.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.nb.core.model")
@EnableJpaRepositories("com.nb.core.repository")
public class JpaConfig {
}
