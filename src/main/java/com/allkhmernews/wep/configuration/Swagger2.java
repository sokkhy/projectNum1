/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.allkhmernews.wep.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @author 
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
@Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
        
    }
    public ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfo(
                "Spring Restful Web Service",
                "Korea Software HRD",
                "API Spring", 
                "Term of Service", 
                "Vuthy Sokkhy sokkhythy@gmail.com", 
                "License of API", 
                "www.facebook.com/sok.key3");
        return apiInfo;
            
    }
}
