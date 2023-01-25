package com.example.RecipeApi.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@Configuration //(this is not enabled in the other demo lessons -- possible reason for bug)
@EnableWebSecurity(debug = true)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                //disable CSRF for Postman usage
                .csrf(csrf -> csrf.disable())
                //.sessionManagement()
                //.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                //.and()
                //authorize all requests to access CSS and JavaScript // added webjars (img probably irrelevant)
                .authorizeRequests(auth -> auth
                        .antMatchers("/css", "/js").permitAll()
                        //allow all requests to read recipes and reviews
                        .antMatchers(HttpMethod.GET, "/recipes/**", "/review").permitAll()
                        //allow creation of new recipes and reviews
                        .antMatchers(HttpMethod.POST, "/recipes", "/review").permitAll()
                        //all other requests should be authenticated
                        .anyRequest().authenticated())
                //users should log in with HTTP Basic.
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
