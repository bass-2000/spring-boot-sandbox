package ru.bass2000.springbootsandbox.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Slf4j
@Configuration
@AllArgsConstructor
public class AppConfiguration {
    private final BuildProperties buildProperties;

    @Bean
    @ConditionalOnExpression("${spring.swaggerEnabled:true}")
    public Docket swaggerConfiguration(@Value("${spring.swagger.apiinfo.title}") String title,
                                       @Value("${spring.swagger.apiinfo.description}") String description,
                                       @Value("${spring.swagger.apiinfo.contact.name}") String name,
                                       @Value("${spring.swagger.apiinfo.contact.email}") String email,
                                       @Value("${spring.swagger.docket.basePackage}") String basePackage) {
        SwaggerConfiguration swaggerConfiguration = new SwaggerConfiguration(buildProperties);
        return swaggerConfiguration.requestDocket(title, description, name, email, basePackage);
    }

}
