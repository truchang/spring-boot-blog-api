package com.springboot.blog.config;



import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

import java.util.Collections;


@OpenAPIDefinition(
        info = @Info(
                title = "Spring Boot Blog REST APIs",
                description = "Spring Boot Blog REST API Documentation",
                version = "1",
                termsOfService = "Terms of service",
                contact = @Contact(name = "NguyenTruc", url = "" ,email = "nguyentruc001@gmail.com"),
                license = @License(name = "License of api")
        ),
        servers = {
                @Server(
                        description = "dev",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "test",
                        url = "http://localhost:8080"
                )
        },
        security = @SecurityRequirement(
                name = "JWT"
        )
)

@SecurityScheme(
        name = "JWT",
        in = SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer",
        description = "security desc"
)


public class SwaggerConfig {
}
