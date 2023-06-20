package com.example.eoi.incideitor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
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

/**
 * Clase de configuración de seguridad de Spring.
 */
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@ComponentScan(basePackages = "com.example.eoi.incideitor.config")
@Configuration
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    /**
     * Configura las reglas de seguridad para las solicitudes HTTP.
     *
     * @param http El objeto HttpSecurity para configurar.
     * @return El SecurityFilterChain configurado.
     * @throws Exception Si ocurre algún error durante la configuración.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Configuración de inicio de sesión
        http.formLogin(form -> form
                .loginPage("/acceso/login")
                .failureUrl("/login-error")
                .defaultSuccessUrl("/",true)
                .permitAll()
        );

        // Configuración de cierre de sesión
        http.logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
        );

        // Configuración de autorizaciones para solicitudes HTTP
        http.authorizeHttpRequests()
                .requestMatchers("/js/**").permitAll()
                .requestMatchers("/img/**").permitAll()
                .requestMatchers("/css/**").permitAll()
                .requestMatchers("/uploads/**").permitAll()
                // Añadimos la siguiente línea para poder acceder más facilmente
//                .requestMatchers("/**").permitAll()
                .requestMatchers("/","").permitAll()
                .requestMatchers("/usuario/create").permitAll()
                .requestMatchers("/usuario/miperfil").hasAuthority("ROL_USUARIO")
                .requestMatchers("/usuario/all").hasAuthority("ROL_USUARIO")
                .requestMatchers("/*/admin").hasAuthority("ROL_ADMINISTRADOR")
                .requestMatchers("/ayuntamiento/datosayuntamiento").hasAuthority("AYUNTAMIENTO_ADMIN")
                .anyRequest().authenticated()

                .and()
                .exceptionHandling()
                .accessDeniedPage("/acceso/accessDenied")

                .and()
                .csrf().disable()
                .cors().disable()
                .authenticationProvider(authenticationProvider());

        return http.build();
    }

    /**
     * Crea un proveedor de autenticación personalizado.
     *
     * @return El proveedor de autenticación.
     */
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(encoder);
        return authenticationProvider;
    }

    /**
     * Configura los prefijos para los roles de autorización.
     *
     * @return Los prefijos de autorización configurados.
     */
    @Bean
    static GrantedAuthorityDefaults grantedAuthorityDefaults() {
        return new GrantedAuthorityDefaults("ROL_");
    }

    /**
     * Ignora las solicitudes al endpoint "/h2-console/**" para acceder a la consola H2.
     *
     * @return El WebSecurityCustomizer configurado.
     */
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
    }
}