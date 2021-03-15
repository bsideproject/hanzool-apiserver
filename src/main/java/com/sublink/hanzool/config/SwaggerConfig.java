package com.sublink.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket swaggerAPI() {
    //@formatter:off
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(swaggerApiInfo())
      .select()
      // .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
      .apis(RequestHandlerSelectors.basePackage("com.sublink.api.controller")).paths(PathSelectors.ant("/api/**"))
      .build()
      .useDefaultResponseMessages(false);
    //@formatter:on
  }

  private ApiInfo swaggerApiInfo() {
    ApiInfoBuilder apiBuilder = new ApiInfoBuilder();
    //@formatter:off
    return apiBuilder
      .version("1.0")
      .title("Sublink API Documentation")
      .description("서브링크 API 서버 문서입니다.")
      .license("Sublink")
      .licenseUrl("https://github.com/bsideproject/sublink-apiserver")
      .build();
    //@formatter:on
  }

}
