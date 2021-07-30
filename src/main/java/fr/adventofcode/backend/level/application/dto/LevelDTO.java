package fr.adventofcode.backend.level.application.dto;

import java.util.Date;

public class LevelDTO {
    private  String name;
    private Date created_at;
    private int gain;

    public LevelDTO( String name, Date created_at, int gain){
        this.name = name;
        this.created_at = created_at;
        this.gain = gain;
    }



    public String getName() {
        return this.name;
    }

    public Date getCreatedAt() {
        return this.created_at;
    }

    public int getGain() {
        return gain;
    }


}
