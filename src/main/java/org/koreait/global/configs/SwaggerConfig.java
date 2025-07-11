package org.koreait.global.configs;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info=@Info( title = "중고 물품 판매", license = @License(name = "MIT"), contact=@Contact(email = "jigu1993@naver.com")))
public class SwaggerConfig {
    /**
     *
     * @return
     */
    public GroupedOpenApi groupedOpenApi(){
        return GroupedOpenApi.builder().group("중고 물품 판매").pathsToMatch("/**").build();
    }




}
