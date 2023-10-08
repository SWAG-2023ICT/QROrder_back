package swag.qrorder.common.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI qrorderAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("project QROrder API 명세서")
                        .description("TEST 및 API 명세서로 사용함."));
    }
}
