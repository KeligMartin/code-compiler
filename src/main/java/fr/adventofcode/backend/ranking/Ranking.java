package fr.adventofcode.backend.ranking;

public class Ranking {

    private String username;

    private Integer gain;

    public Ranking(String username, Integer gain) {
        this.username = username;
        this.gain = gain;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getGain() {
        return gain;
    }

    public void setGain(Integer gain) {
        this.gain = gain;
    }
}
