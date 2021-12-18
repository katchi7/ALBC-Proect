package com.ensias.albcuserService.config;

import lombok.extern.log4j.Log4j2;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerTypePredicate;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@Log4j2
public class WebConfig implements WebMvcConfigurer {
    @Value("${context-path}")
    private String contextPath;
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {

        String appBasePackage = com.ensias.albcuserService.AlbcUserServiceApplication.class.getPackage().getName();
        configurer.addPathPrefix(contextPath, HandlerTypePredicate.forBasePackage(appBasePackage));
        LoggerFactory.getLogger(getClass().getName()).info("App Started");
    }

}
