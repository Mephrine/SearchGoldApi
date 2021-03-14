package kr.co.youngyoung.goldnawa.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig{
    @Value("${api.key}")
    private String SERVER_API_KEY;

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Goldnawa")
                .description("API EXAMPLE")
                .build();
    }

    @Bean
    public Docket api() {
        ParameterBuilder parameterBuilder = new ParameterBuilder();

        parameterBuilder.name("api-key")
                .description("goldnawa api-key")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(true)
                .defaultValue(SERVER_API_KEY)
                .hidden(true)
                .build();

        List<Parameter> parameters = new ArrayList<>();
        parameters.add(parameterBuilder.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(parameters)
                .groupName("example")
                .apiInfo(this.apiInfo())
                .select()
                .apis(RequestHandlerSelectors.any()) // 현재 RequestMapping에 할당된 모든 URL 리스트 셀렉트 추출
                .paths(PathSelectors.ant("/v*/api/**")) // /v*/api/** 인 URL만 필터링
                .build();
    }
}
