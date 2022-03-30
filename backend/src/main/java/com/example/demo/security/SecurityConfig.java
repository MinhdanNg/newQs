package com.example.demo.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${spring.security.oauth2.resourceserver.jwt.jwk-set-uri}")
    private String jwkSetUrl;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/demo/**").hasAuthority("SCOPE_openid")
                .antMatchers(HttpMethod.POST, "/demo").hasAuthority("SCOPE_openid")
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();
        //coder(jwtDecoder());
    }


    /*
    @Bean
    public JwtDecoder jwtDecoder() {
        JWSKeySelector<SecurityContext> jwsKeySelector = null;
        try {
            jwsKeySelector = JWSAlgorithmFamilyJWSKeySelector.fromJWKSetURL(new URL(this.jwkSetUrl));
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }

        final DefaultJWTProcessor<SecurityContext> jwtProcessor = new DefaultJWTProcessor<>();
        jwtProcessor.setJWSKeySelector(jwsKeySelector);
        jwtProcessor.setJWSTypeVerifier(new DefaultJOSEObjectTypeVerifier<>(new JOSEObjectType("JWT")));

        return new NimbusJwtDecoder(jwtProcessor);
    }

    */

}
