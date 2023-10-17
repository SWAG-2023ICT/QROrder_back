package swag.qrorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class QrorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(QrorderApplication.class, args);
    }

}
