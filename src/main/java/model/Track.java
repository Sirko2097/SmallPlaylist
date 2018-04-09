package model;

public class Track {
    private String performer;
    private String name;
    private double duration;
    private String genre;

    public Track(String performer, String name, double duration, String genre) {
        this.performer = performer;
        this.name = name;
        this.duration = duration;
        this.genre = genre;
    }

    public String getPerformer() {
        return performer;
    }

    public String getName() {
        return name;
    }

    public double getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }
}