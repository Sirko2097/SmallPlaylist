package dao.implementations;

import dao.interfaces.DAOTrack;
import model.Track;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for realization DAOTrack interface
 * */

public class DAOTrackImpl implements DAOTrack {
    private final Connection connection;

    public DAOTrackImpl(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Track create() {
        return null;
    }

    @Override
    public Track read(int key) throws SQLException {
        PreparedStatement prStat = connection.prepareStatement("SELECT performer, name, duration, genre FROM musicLib.tracks WHERE id = ?");
        prStat.setInt(1, key);

        ResultSet resultSet = prStat.executeQuery();
        resultSet.next();
        return new Track(resultSet.getString("performer"), resultSet.getString("name"),
            resultSet.getDouble("duration"), resultSet.getString("genre"));
    }

    /**
     * This method return all records from DB
     *
     * @return List of tracks
     * */
    @Override
    public List<Track> getAll() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT performer, name, duration, genre FROM tracks");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Track> tracks = new ArrayList<>();

        while (resultSet.next()) {
            tracks.add(new Track(resultSet.getString("performer"), resultSet.getString("name"),
                    resultSet.getDouble("duration"), resultSet.getString("genre")));
        }

        return tracks;
    }

    /**
     * This method searches track in DB by the performer's name.
     * It works well with small amount of records.
     *
     * @param performerName - name of performer which user input
     * @return song from DB, if the record was found
     * */
    @Override
    public Track findTrackByPerformer(String performerName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT performer, name, duration, genre\n" +
                "FROM musicLib.tracks WHERE tracks.performer = '" + performerName + "'");
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Track(resultSet.getString("performer"), resultSet.getString("name"),
                    resultSet.getDouble("duration"), resultSet.getString("genre"));
        } else return null;
    }


    /**
     * This method searches track in DB by the performer's name.
     * It works well with small amount of records.
     *
     * @param nameStr - name of the song, which user input
     * @return song from DB, if the record was found
     * */
    @Override
    public Track findTrackByName(String nameStr) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT performer, name, duration, genre\n" +
                "FROM musicLib.tracks WHERE tracks.name = '" + nameStr + "'");
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return new Track(resultSet.getString("performer"), resultSet.getString("name"),
                    resultSet.getDouble("duration"), resultSet.getString("genre"));
        } else return null;
    }

    /**
     * This method finds the longest song.
     * If there are some song with the same duration - return one of them.
     *
     * @return the longest song from DB
     * */
    @Override
    public Track getTheLongestTrack() throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT DISTINCT performer, name, duration, genre\n" +
                "FROM musicLib.tracks WHERE (duration) IN \n" +
                "                           (SELECT max(duration) FROM musicLib.tracks)");
        ResultSet resultSet = preparedStatement.executeQuery();


        if (resultSet.next()) {
            return new Track(resultSet.getString("performer"), resultSet.getString("name"),
                    resultSet.getDouble("duration"), resultSet.getString("genre"));
        }
        else return null;
    }
}
