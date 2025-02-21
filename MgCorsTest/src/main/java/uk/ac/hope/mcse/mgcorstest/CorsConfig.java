package uk.ac.hope.mcse.mgcorstest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Value("${cors.allowed-origins}")
    private String[] allowedOrigins; // Read from properties file

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                                                      // Apply to all endpoints
                .allowedOrigins(allowedOrigins)                                         // Allow frontend origin
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")              // Allowed HTTP methods
                .allowedHeaders("Content-Type", "Authorization", "X-Requested-With")    // Custom headers
                .allowCredentials(true)                                                 // Allow cookies/authentication
                .maxAge(3600);                                                          // Cache preflight response for 1 hour
    }

}

