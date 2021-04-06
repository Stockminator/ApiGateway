package com.stockminator.apigateway

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity.OAuth2ResourceServerSpec
import org.springframework.security.web.server.SecurityWebFilterChain

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
class SecurityConfig {

    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        return http
                .authorizeExchange()
//                .pathMatchers(HttpMethod.GET, "/hello/**").hasAuthority("ROLE_ADMIN")
                .pathMatchers(HttpMethod.GET, "/hello/**").hasAuthority("ROLE_ADMIN")
                .pathMatchers(HttpMethod.GET, "/bello/**").hasAuthority("ROLE_USER")
                .anyExchange().permitAll()
                .and()
                .oauth2Login()
                .and()
                .oauth2ResourceServer { oauth2: OAuth2ResourceServerSpec -> oauth2.jwt() }
                .csrf().disable()
                .build()
    }
}