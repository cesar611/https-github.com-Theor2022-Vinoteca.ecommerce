package com.tequila.ecommerce.vinoteca.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Tequila API",
                version = "1.0",
                description = "Tequila API Documentation"
        )
)
public class SwaggerConfig {

}