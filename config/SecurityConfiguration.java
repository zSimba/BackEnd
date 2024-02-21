package es.darcalzadilla.backend.config;

import es.darcalzadilla.backend.filter.JwtReqFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final JwtReqFilter jwtReqFilter;

    public SecurityConfiguration(@Lazy JwtReqFilter jwtReqFilter) {
        this.jwtReqFilter = jwtReqFilter;
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails dario = User.builder()
                .username("dario")
                .password("{noop}dario123")
                .roles("admin")
                .build();
        UserDetails roberto = User.builder()
                .username("roberto")
                .password("{noop}roberto123")
                .roles("employee")
                .build();
        UserDetails antonio = User.builder()
                .username("antonio")
                .password("{noop}antonio123")
                .roles("employee")
                .build();
        return new InMemoryUserDetailsManager(dario, roberto, antonio);

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configure -> configure
                .requestMatchers("/v1/auth").permitAll()
                .requestMatchers(HttpMethod.GET, "/v1/controller").hasRole("admin")
                .requestMatchers(HttpMethod.GET, "/v1/controller").hasRole("employee")
                .requestMatchers(HttpMethod.POST, "/v1/controller").hasRole("admin")
                .requestMatchers(HttpMethod.PUT, "/v1/controller").hasRole("admin")
                .requestMatchers(HttpMethod.PUT, "/v1/controller").hasRole("admin")
                .requestMatchers(HttpMethod.DELETE, "/v1/controller").hasRole("employee"))
                .addFilterBefore(jwtReqFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.httpBasic(Customizer.withDefaults());
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
