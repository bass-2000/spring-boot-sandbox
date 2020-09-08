package ru.bass2000.springbootsandbox.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;

@AllArgsConstructor
public class SwaggerConfiguration {
    private final BuildProperties buildProperties;

    @Bean
    public Docket requestDocket(@Value("${spring.swagger.apiinfo.title}") String title,
                                @Value("${spring.swagger.apiinfo.description}") String description,
                                @Value("${spring.swagger.apiinfo.contact.name}") String name,
                                @Value("${spring.swagger.apiinfo.contact.email}") String email,
                                @Value("${spring.swagger.docket.basePackage}") String basePackage) {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(requestApiInfo(title, description, name, email));

    }

    private ApiInfo requestApiInfo(String title,
                                   String description,
                                   String name,
                                   String email
    ) {
        String version = String.join("_", buildProperties.getVersion(),
                buildProperties.get("commit_hash"),
                LocalDateTime.ofInstant(buildProperties.getTime(), ZoneId.systemDefault()).toString());

        return new ApiInfo(
                title,
                description,
                version,
                null,
                new Contact(name, null, email),
                null,
                null,
                Collections.emptyList()
        );
    }
}
