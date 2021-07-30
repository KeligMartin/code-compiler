package fr.adventofcode.backend;

import fr.adventofcode.backend.quality.listeners.python.PythonLineLengthListener;
import fr.adventofcode.backend.quality.listeners.python.FunctionNameListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
public class AdventOfCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdventOfCodeApplication.class, args);
    }

    @GetMapping("/")
    public ResponseEntity health(){
        return ResponseEntity.ok().build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                        .addMapping("/**").
                        allowedMethods("*")
                        .allowedOrigins("http://localhost:4200", "http://advent-of-code-angular.s3-website.us-east-2.amazonaws.com")
                        .exposedHeaders("Location");
            }
        };
    }
}
