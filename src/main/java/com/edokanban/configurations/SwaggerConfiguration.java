package com.edokanban.configurations;

import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI kanbanApiInfo() {
        return new OpenAPI()
            .info(new Info()
                .title("Kanban API")
                // カンバンタスクを管理するためのREST API
                //管理（かんり）
                .description("API REST for managing Kanban tasks |  カンバンタスクを管理するためのREST API")
                .version("1.0.0")
                .contact(new Contact()
                    .name("Edogawa Araújo")
                    .email("edison.araujo22@gmail.com")
                    .url("https://github.com/EdogawaCoder")))
            .servers(List.of(
                new Server().url("http://localhost:8081").description("Local Server")));
    }

    @Bean
    public GroupedOpenApi groupedOpenApi() {
        return GroupedOpenApi.builder()
            .group("kanban")
            .pathsToMatch("/**")
            .build();
    }
}
