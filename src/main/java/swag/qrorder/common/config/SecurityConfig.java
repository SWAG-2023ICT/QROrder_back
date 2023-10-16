package swag.qrorder.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import swag.qrorder.common.filter.JwtExceptionHandler;
import swag.qrorder.common.filter.JwtFilter;
import swag.qrorder.common.util.TokenUtil;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {
    private final String[] SWAGGER_URL = {
            "/swagger-ui/**",
            "/qrorder/**"
    };
    private final TokenUtil tokenUtil;

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean(value = "JwtFilter")
    public JwtFilter jwtFilter(){ return new JwtFilter(tokenUtil);}

    @Bean(value = "JwtExceptionHandler")
    public JwtExceptionHandler jwtExceptionHandler(){ return new JwtExceptionHandler();}

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(SWAGGER_URL).permitAll()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(jwtExceptionHandler(), JwtFilter.class);
        return  httpSecurity.build();
    }
}
