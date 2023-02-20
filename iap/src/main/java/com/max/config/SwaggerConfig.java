package com.max.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
public class SwaggerConfig{
    //用于封装接口文档信息
    @Bean
    public Docket getDocket(){
        //cover information
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
        apiInfoBuilder.title("Interface Instructions for Max shopping platform")
                .version("1.0-SNAPSHOT")
                .contact(new Contact("Max Zhang","","Zhangxjmzf@163.com"));
        ApiInfo apiInfo = apiInfoBuilder.build();

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.max.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

}
