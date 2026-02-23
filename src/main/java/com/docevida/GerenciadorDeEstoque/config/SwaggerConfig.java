package com.docevida.GerenciadorDeEstoque.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI (){
        return new OpenAPI()
                .info(new Info()
                        .title("API Gerenciador de Estoque")
                        .version("1.0")
                        .description("Descrição dos endpoints para o frontend")
                )
                .externalDocs(new ExternalDocumentation()
                        .description("Link do repositorio deste projeto")
                        .url("https://github.com/LuizRibeir0/GerenciadorDeEstoque")
                );
    }
}
