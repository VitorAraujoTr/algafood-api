package com.algaworks.algafoodapi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AlgafoodApiApplication implements CommandLineRunner {

    public static void main(String... args) {
        SpringApplication.run(AlgafoodApiApplication.class, args);
    }

    @Bean
    public Main getMain() {
        return new MainImpl();
    }

    @Override
    public void run(String... args) {
        getMain().main();
    }
}
