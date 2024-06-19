package br.com.api.biju.gestao_loja.modules.cliente.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/produto/create").permitAll()
                            .requestMatchers("/cliente/").permitAll()
                            .requestMatchers("/pecacorda").permitAll()
                            .requestMatchers("/pecapingente/create").permitAll()
                            .requestMatchers("/user/create").permitAll();
                    auth.anyRequest().authenticated();
                });
        return http.build();
    }
}
