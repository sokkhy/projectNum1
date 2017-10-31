package com.allkhmernews.wep.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by MSI on 7/6/2017.
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/upload").setViewName("upload");

    }
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/store/**")
                .addResourceLocations("file:/key/image");
    }
}
