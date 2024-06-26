package org.sbet.clr.roomcleanernotifier;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private ConfigurableApplicationContext applicationContext;
    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    public Runner(RabbitTemplate rabbitTemplate, ObjectMapper objectMapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        int index = (int) (Math.random() * (28 - 1) + 1);
        AsyncPayload payload = new AsyncPayload();
        payload.setId(index);
        payload.setModel("ROOM");
        rabbitTemplate.convertAndSend("operations", "landon.rooms.cleaner", objectMapper.writeValueAsString(payload));
        applicationContext.close();
    }
}
