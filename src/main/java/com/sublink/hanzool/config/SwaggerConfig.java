package com.sublink.hanzool.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
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
      .apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
      // .apis(RequestHandlerSelectors.withMethodAnnotation(Api.class))
      // .apis(RequestHandlerSelectors.basePackage("com.sublink.hanzool.controller")).paths(PathSelectors.ant("/api/**"))
      .build()
      .genericModelSubstitutes(Optional.class, Flux.class, Mono.class)
      .useDefaultResponseMessages(false);
    //@formatter:on
  }

  private ApiInfo swaggerApiInfo() {
    ApiInfoBuilder apiBuilder = new ApiInfoBuilder();
    //@formatter:off
    return apiBuilder
      .version("1.0")
      .title("HANZOOL API Documentation")
      .description("`Sublink` 팀의 한줄평 서비스 API 서버 문서입니다.")
      .license("hanzool")
      .licenseUrl("https://github.com/bsideproject/hanzool-apiserver")
      .build();
    //@formatter:on
  }

}
