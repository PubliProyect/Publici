package com.vimso.padyu.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@Import({DatabaseConfig.class})
@EnableJpaRepositories(basePackages={"com.vimso.padyu.bussines.dao.repositorios"})
@ComponentScan(basePackages = {"com.vimso.padyu.web.webservice.rest.services.*","com.vimso.padyu.bussines.*","com.vimso.padyu.utils.traductor"})

public class WebAppContext extends WebMvcConfigurerAdapter{ 

    private static final String MESSAGE_SOURCE_BASE_NAME = "i18n/messageSource";
    
     @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename(MESSAGE_SOURCE_BASE_NAME);
        messageSource.setUseCodeAsDefaultMessage(true);

        return messageSource;
    }
}
