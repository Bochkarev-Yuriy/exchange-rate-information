package exchange.rate.information.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.configuration.Swagger2DocumentationConfiguration;

/**
 * @author Yuriy Bochkarev
 * @since 22.02.18.
 */

@Configuration
@ComponentScan(value = {"exchange.rate.information.controller.rest"})
@EnableWebMvc
@EnableSwagger2
@Import(SpringWebConfig.class)
public class SwaggerConfig extends Swagger2DocumentationConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("exchange.rate.information.controller.rest"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "EXCHANGE RATE INFORMATION API DOCUMENTATION",
                "Документация по rest api методам сервиса exchange-rate-information.",
                "1.0 SNAPSHOT",
                "В стадии разработки",
                new Contact(
                        "Yuriy Bochkarev",
                        "",
                        "bochkarev.yuriy.i@gmail.com"),
                "distributed by ",
                "index.html");
        return apiInfo;
    }
}
