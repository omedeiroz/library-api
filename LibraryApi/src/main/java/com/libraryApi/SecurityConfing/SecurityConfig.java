package com.libraryApi.SecurityConfing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()  // Permite acesso ao console H2
                        .anyRequest().authenticated()  // Exige autenticação para outros endpoints
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")  // Desabilita CSRF para o console H2
                )
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.disable())  // Desabilita X-Frame-Options
                )
                .httpBasic(Customizer.withDefaults());  // Configura autenticação básica

        return http.build();
    }
}