package org.sbet.clr.roomclr;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {
    private long id;
    private String number;
    private String name;
    private String info;

    public Room() {
    }

    public Room(long id, String number, String name, String info) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.info = info;
    }
}
