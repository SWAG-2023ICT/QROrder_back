package swag.qrorder.common.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI qrorderAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("project QROrder API 명세서")
                        .description("TEST 및 API 명세서로 사용함."))
                .addSecurityItem(new SecurityRequirement().addList("bearer-key"))
                .components(new Components()
                        .addSecuritySchemes("bearer-key",
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }

    @Bean
    public GroupedOpenApi authAPI(){
        return GroupedOpenApi.builder()
                .group("auth")
                .pathsToMatch("/qrorder/auth/**")
                .build();
    }

    @Bean
    public GroupedOpenApi reservationAPI(){
        return GroupedOpenApi.builder()
                .group("reservation")
                .pathsToMatch("/qrorder/reservation/**")
                .build();
    }

    @Bean
    public GroupedOpenApi restaurantAPI(){
        return GroupedOpenApi.builder()
                .group("restaurants")
                .pathsToMatch("/qrorder/restaurants/**")
                .build();
    }
    @Bean
    public GroupedOpenApi seatAPI(){
        return GroupedOpenApi.builder()
                .group("seats")
                .pathsToMatch("/qrorder/seats/**")
                .build();
    }
    @Bean
    public GroupedOpenApi userAPI(){
        return GroupedOpenApi.builder()
                .group("menus")
                .pathsToMatch("/qrorder/menus/**")
                .build();
    }
    @Bean
    public GroupedOpenApi itemAPI(){
        return GroupedOpenApi.builder()
                .group("items")
                .pathsToMatch("/qrorder/items/**")
                .build();
    }
}