package org.sbet.landon.roomwebapp.async;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.sbet.landon.roomwebapp.models.Room;
import org.sbet.landon.roomwebapp.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@Transactional
public class RoomCleanerListener {
    public static final Logger LOG = LoggerFactory.getLogger(RoomCleanerListener.class);

    private final ObjectMapper mapper;
    private final RoomService roomService;

    public RoomCleanerListener(ObjectMapper mapper, RoomService roomService) {
        this.mapper = mapper;
        this.roomService = roomService;
    }

    public void receiveMessage(String message) {
        try {
            AsyncPayload asyncPayload = mapper.readValue(message, AsyncPayload.class);
            if ("ROOM".equals(asyncPayload.getModel())) {
                Room room = roomService.getById(asyncPayload.getId());
                LOG.info("Cleaning room required {}:{}", room.getNumber(), room.getName());
            } else {
                LOG.warn("Unknown model type");
            }
        } catch (JsonProcessingException e ) {
            e.printStackTrace();
        }
    }
}
