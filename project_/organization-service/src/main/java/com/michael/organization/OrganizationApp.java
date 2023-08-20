package com.michael.organization;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Organization Service REST APIs",
                description = "Organization Service REST APIs Documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Michael Royf",
                        email = "michael.royf87@gmail.com",
                        url = "https://www.linkedin.com/in/michael-royf-13509617a/"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.linkedin.com/in/michael-royf-13509617a/"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Organization-Service Doc",
                url = "https://www.linkedin.com/in/michael-royf-13509617a/"
        )
)
public class OrganizationApp {
    public static void main(String[] args) {
        SpringApplication.run(OrganizationApp.class, args);
    }
}
