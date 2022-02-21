package com.mmutawe.explore.spring.data.jpa.exploringjpa.configs;

import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("clean")
public class DbClean {

    @Bean
    public FlywayMigrationStrategy clean(){
        return flyway -> {
            // clean will drop all the database objects and then
            // rebuild from the flyway migration scripts.
            flyway.clean();
            flyway.migrate();
        };
    }
}
