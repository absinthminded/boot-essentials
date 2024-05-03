package org.sbet.clr.fizzbull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;

import java.util.List;

@SpringBootApplication
public class FizzBullApplication {
    public static final Logger LOG = LoggerFactory.getLogger(FizzBullApplication.class);

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            LOG.info("Running command line runner");

            for (int i = 0; i < 100; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    LOG.info("FizzBuzz");
                    continue;
                }
                if (i % 3 == 0) {
                    LOG.info("Fizz");
                    continue;
                }
                if (i % 5 == 0) {
                    LOG.info("Buzz");
                    continue;
                }
                System.out.println(i);
            }

            LOG.info("Finished running command line runner");
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(FizzBullApplication.class, args);
    }

}
