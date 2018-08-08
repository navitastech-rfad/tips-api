package com.navitas.rfad.config;

import javax.inject.Inject;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource; 

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
  @Inject
  public void configureGlobal(final AuthenticationManagerBuilder auth) {

    final SimpleAuthorityMapper mapper = new SimpleAuthorityMapper();
    //    mapper.setConvertToUpperCase(true);

    final KeycloakAuthenticationProvider provider = keycloakAuthenticationProvider();
    provider.setGrantedAuthoritiesMapper(mapper);

    auth.authenticationProvider(provider);
  }

  @Bean
  public KeycloakSpringBootConfigResolver keycloakConfigResolver() {
    return new KeycloakSpringBootConfigResolver();
  }

  @Bean
  @Override
  protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
    return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    // http.cors().and().csrf().disable().authorizeRequests().antMatchers("/actuator/**").permitAll();
    super.configure(http);
    http.authorizeRequests()
        .antMatchers("/api/tips/create", "/actuator/**")
        .permitAll()
        .and()
        .authorizeRequests()
        .anyRequest()
        .authenticated();
  }

  @Bean
  CorsConfigurationSource corsConfigurationSource() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
    return source;
  }
}
