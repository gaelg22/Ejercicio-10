package com.upiiz.ligas_deportivas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Permitir cookies / tokens
        config.setAllowCredentials(true);

        // ORÍGENES PERMITIDOS
        config.setAllowedOrigins(List.of(
            "http://localhost:4200",
            "https://g10-zynn.onrender.com",
            "https://proyecto-final-z1qz.onrender.com"
        ));

        // HEADERS PERMITIDOS
        config.setAllowedHeaders(List.of("*"));

        // MÉTODOS PERMITIDOS
        config.setAllowedMethods(List.of(
            "GET", "POST", "PUT", "DELETE", "OPTIONS"
        ));

        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
