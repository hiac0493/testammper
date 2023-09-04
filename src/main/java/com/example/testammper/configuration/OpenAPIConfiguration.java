package com.example.testammper.configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenAPIConfiguration {

    @Value("${info.app.name}")
    String appName;

    @Value("${info.app.description}")
    String appDescription;

    @Value("${info.app.version}")
    String appSemver;



    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("api")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title(appName)
                        .description(appDescription)
                        .version("v".concat(appSemver)));
    }

}

