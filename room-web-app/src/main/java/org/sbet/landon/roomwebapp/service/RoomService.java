package org.sbet.landon.roomwebapp.service;

import org.sbet.landon.roomwebapp.data.RoomRepository;
import org.sbet.landon.roomwebapp.models.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getById(long id) {
        return roomRepository.getReferenceById(id);
    }
}