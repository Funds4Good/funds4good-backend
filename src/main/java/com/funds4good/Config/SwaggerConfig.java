package com.funds4good.Config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition (
        info = @Info(
                title = "Fund4Good API Documentation",
                version = "1.0",
                description = "Complete API documentation for spring application."),
        servers = {
                @Server(
                        url = "https://fund4good.pranavbisaria.live",
                        description = "Production server"
                ),
                @Server(
                        url = "http://localhost:8181",
                        description = "Local server"
                )
        }
)
@SecurityScheme(
        name = "Bearer Token",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        description  = "JWT Access Token for authentication"
)
public class SwaggerConfig {
}