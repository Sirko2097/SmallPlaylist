package model;

import org.apache.log4j.Logger;

import java.util.Comparator;

public class TrackComparator implements Comparator<Track> {
    private final static Logger logger = Logger.getLogger(TrackComparator.class);
    @Override
    public int compare(Track thisTrack, Track anotherTrack) {
        logger.info("Text comparator was initiated.");
        return thisTrack.getName().compareTo(anotherTrack.getName());
    }

}
