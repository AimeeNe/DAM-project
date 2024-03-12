package com.avl.damback;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "DAM API", version = "3.0", description = "DAM Information"))
public class DambackApplication {

    public static void main(String[] args) {
        SpringApplication.run(DambackApplication.class, args);
    }

}
