package dao.interfaces;

import model.Track;

import java.sql.SQLException;
import java.util.List;

public interface DAOTrack {
    Track create();

    Track read (int key) throws SQLException;

    List<Track> getAll() throws SQLException;

    Track getTheLongestTrack() throws SQLException;

    Track findTrackByName(String name) throws SQLException;

    Track findTrackByPerformer(String performerName) throws SQLException;

}
