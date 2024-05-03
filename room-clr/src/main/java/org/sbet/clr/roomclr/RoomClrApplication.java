package org.sbet.clr.roomclr;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
public class RoomClrApplication {
    public static final Logger LOG = LoggerFactory.getLogger(RoomClrApplication.class);
    public static final String API_ROOMS = "http://localhost:8080/api/rooms";

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            LOG.info("Running command line runner");

            ResponseEntity<List<Room>> rooms = restTemplate.exchange(API_ROOMS, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Room>>() {
                    });

            rooms.getBody().forEach( room -> {
                LOG.info("Found room: {}", room.toString());
            });
            LOG.info("Finished running command line runner");
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(RoomClrApplication.class, args);
    }

}
