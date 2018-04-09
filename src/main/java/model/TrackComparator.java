package model;

import java.util.Comparator;

public class TrackComparator implements Comparator<Track> {

    @Override
    public int compare(Track thisTrack, Track anotherTrack) {
        return thisTrack.getName().compareTo(anotherTrack.getName());
    }

}
