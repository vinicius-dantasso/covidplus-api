package br.edu.ufersa.covidplus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.edu.ufersa.covidplus.api.filters.LoginFilter;
import br.edu.ufersa.covidplus.domain.service.UserDetailsServiceImpl;
import br.edu.ufersa.covidplus.api.filters.AuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    
    @Autowired
  private UserDetailsServiceImpl userDetailsService;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain configure(HttpSecurity http) throws Exception {
    AuthenticationManagerBuilder authenticationManagerBuilder = 
      http.getSharedObject(AuthenticationManagerBuilder.class);

    authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
    http
      .cors().and()
      .csrf().disable().authorizeHttpRequests()
      .antMatchers(HttpMethod.POST, "/api/login").permitAll()
      .antMatchers(HttpMethod.POST, "/api/user").permitAll()
      .antMatchers( "/api/images/**").permitAll()
      .anyRequest().authenticated().and()
      .addFilterBefore(new LoginFilter("/api/login", authenticationManager), UsernamePasswordAuthenticationFilter.class)
      .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
      .authenticationManager(authenticationManager)
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    http
      .headers()
      .frameOptions()
      .disable();

    return http.build();
  }

}
