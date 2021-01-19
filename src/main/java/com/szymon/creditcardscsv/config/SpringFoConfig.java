package com.szymon.creditcardscsv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SpringFoConfig {
    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("public-api")
                .apiInfo(apiInfo()).select().build();
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Persons list csv API")
                .description("API do przechowywania danych kart kredytowych klientów")
                .contact("szymon.zsp5@gmail.com").license("(un)license")
                .licenseUrl("https://unlicense.org/").version("1.0").build();
    }
}
