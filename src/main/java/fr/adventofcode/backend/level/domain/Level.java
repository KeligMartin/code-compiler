package fr.adventofcode.backend.level.domain;

import java.util.Date;

public class Level {
    private String id;
    private String name;
    private Date createdAt;
    private int gain;

    public Level(String name, Date createdAt, int gain){
        this.name = name;
        this.createdAt = createdAt;
        this.gain = gain;
    }

    public Level(String id, String name, Date createdAt, int gain){
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.gain = gain;
    }

    public Level(String id){
        this.id = id;
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Date getCreatedAt() { return createdAt; }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public int getGain() { return gain; }

    public void setGain(int gain) {this.gain = gain; }
}
