package com.vml.usmc.influencers.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI promotionsOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("USMC VML Influencers API")
                        .description("API for managing USMC influencers and influencer content")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("VML")
                                .url("https://www.vml.com"))
                        .license(new License()
                                .name("Private")))
                .servers(List.of(
                        new Server()
                                .url("/")
                                .description("Default Server URL")));
    }
}
