package com.example.eoi.incideitor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@ComponentScan(basePackages = "com.example.eoi.incideitor.config")
@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    /*

    https://stackoverflow.com/questions/75080739/spring-security-6-post-requests-are-unauthorised-with-permitall
https://stackoverflow.com/questions/28907030/spring-security-authorize-request-for-certain-url-http-method-using-httpsecu
https://www.baeldung.com/spring-security-csrf
     */

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin(form -> form
                        .loginPage("/acceso/login")
                        .failureUrl("/login-error")
                        .defaultSuccessUrl("/",true)
                        .permitAll()
                );
        http.logout(logout -> logout
                        .logoutUrl("/acceso/logout")
                        .logoutSuccessUrl("/")
                        /*.logoutSuccessHandler(logoutSuccessHandler)
                        .invalidateHttpSession(true)
                        .addLogoutHandler(logoutHandler)
                        .deleteCookies(cookieNamesToClear)*/
                );
        http.authorizeHttpRequests()
                .requestMatchers("/js/**").permitAll()
                .requestMatchers("/img/**").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/uploads/**").permitAll()
                //.requestMatchers("/**").permitAll()
                .requestMatchers("/**").permitAll()
                .requestMatchers("/usuario/create").permitAll()
                .requestMatchers( HttpMethod.POST,"/**").permitAll()
                //.requestMatchers( HttpMethod.POST,"/usuarios/*").hasAuthority("ROLE_ADMIN")
                //.requestMatchers( HttpMethod.GET,"/usuarios/*").hasAuthority("ROLE_ADMIN")
                //.requestMatchers( HttpMethod.PUT,"/usuarios/*").hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated()

                .and()
                .exceptionHandling()
                .accessDeniedPage("/accessDenied")

                .and()
                .csrf().disable()
                .cors().disable()
                .authenticationProvider(authenticationProvider());

        return http.build();

    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(encoder);
        return authenticationProvider;
    }
    @Bean
    static GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("ROL_");
    }


    ///nos saltamos la restricion para entrar a h2-console///

    @Bean

    public WebSecurityCustomizer webSecurityCustomizer() {

        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));

    }

}