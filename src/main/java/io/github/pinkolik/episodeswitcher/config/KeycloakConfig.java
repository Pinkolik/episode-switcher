package io.github.pinkolik.episodeswitcher.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    //https://www.appsloveworld.com/springboot/100/9/how-to-configure-multiple-keycloak-sso-clients-in-spring-boot-application
    @Bean
    public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
        return new KeycloakSpringBootConfigResolver();
    }
}