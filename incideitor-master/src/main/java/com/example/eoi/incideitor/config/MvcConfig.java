package com.example.eoi.incideitor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**

 Clase de configuración para Spring MVC.
 */
@Configuration
@ComponentScan(basePackages = "com.example.eoi.incideitor.config")
public class MvcConfig implements WebMvcConfigurer {

    /**

     Crea un bean para el resolver de localización.
     Establece la localización predeterminada a español (España).
     @return El resolver de localización configurado.
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.forLanguageTag("es_ES"));
        return slr;
    }
    /**

     Crea un bean para el interceptor de cambio de localización.
     Establece el nombre del parámetro para el cambio de localización.
     @return El interceptor de cambio de localización configurado.
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }
    /**

     Agrega el interceptor de cambio de localización al registro de interceptores.
     @param registry El registro de interceptores.
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
}