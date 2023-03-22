package com.example.Ejercicio_4_5_6.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetais())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetais(){
        return new ApiInfo("String boot Laptop API Rest",
                "Library API REST docs",
                "1.0",
                "https://search.brave.com/",
                new Contact("Pepoto","https://search.brave.com/","pepoto" +
                        "@example.com"),
                "MIT",
                "https://search.brave.com/",
                Collections.emptyList());
    }
}
