package com.vimso.padyu.integracion.aprovisionamiento.contextoxCDI;

import com.vimso.padyu.config.*;
import com.mangofactory.swagger.plugin.EnableSwagger;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableSwagger
@EnableJpaRepositories(basePackages={"com.vimso.padyu.bussines.dao.repositorios"})
@ComponentScan(basePackages = {"com.vimso.padyu.web.webservice.rest.services.*","com.vimso.padyu.bussines.*","com.vimso.padyu.utils.traductor"})
public class WebAppContext extends WebMvcConfigurerAdapter{ 

    private static final String MESSAGE_SOURCE_BASE_NAME = "i18n/messageSource";
//
//    @Inject
//     private SpringSwaggerConfig springSwaggerConfig;
     
//    @Bean 
//    public SwaggerSpringMvcPlugin customImplementation() {
//        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig)
//                .apiInfo(apiInfo());
//    }
    
//    private ApiInfo apiInfo() {
//      ApiInfo apiInfo = new ApiInfo(
//              "My Apps API Title",
//              "My Apps API Description",
//              "My Apps API terms of service",
//              "My Apps API Contact Email",
//              "My Apps API Licence Type",
//              "My Apps API License URL"
//        );
//      return apiInfo;
//    }
    
    
    
     @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename(MESSAGE_SOURCE_BASE_NAME);
        messageSource.setUseCodeAsDefaultMessage(true);

        return messageSource;
    }
}
