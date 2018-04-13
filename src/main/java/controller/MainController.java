package controller;

import dao.implementations.DAOFactoryImpl;
import dao.implementations.DAOTrackImpl;
import model.Track;
import model.TrackComparator;
import org.apache.log4j.Logger;
import view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


class MainController {
    private View view = new View();
    private BufferedReader reader;
    private DAOFactoryImpl daoFactory;
    private Connection connection;
    private List<Track> trackList;

    private final static Logger logger = Logger.getLogger(MainController.class);
    //initialization block
    {
        reader = new BufferedReader(new InputStreamReader(System.in));
        daoFactory = new DAOFactoryImpl();
        try {
            connection = daoFactory.getConnection();
            logger.info("Connection was established");
        } catch (SQLException e) {
            logger.error(e);
        }
    }

    /**
     * This method prints sends information to viewer for printing object's attributes
     * @param performer name, who plays this song;
     * @param name of the song;
     * @param duration of the song;
     * @param genre of the song;
     * */
    private void printer(String performer, String name, double duration, String genre){
        view.printElement("\nPerformer: ", performer);
        view.printElement("Name: ", name);
        view.printElement("Duration: ", String.valueOf(duration));
        view.printElement("Genre: ", genre);
        view.printElement("-------","-------\n");
    }


    /**
     * Print all songs from DB.
     * */
    void printPlaylist() {
        try {
            trackList = daoFactory.getDAOTrackImpl(connection).getAll();
            for (Track track : trackList) {
                printer(track.getPerformer(), track.getName(), track.getDuration(), track.getGenre());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Find record from db by performer and then print it.
     * */
    void findByPerformer() {
        view.printElement("Input performer: ");
        String performer = null;
        Track track;
        try {
            performer = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            track = daoFactory.getDAOTrackImpl(connection).findTrackByPerformer(performer);
            printer(track.getPerformer(), track.getName(), track.getDuration(), track.getGenre());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Find record from db by song's name and then print it.
     * */
    void findByName() {
        view.printElement("Input name: ");
        String name = null;
        Track track;
        try {
            name = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            track = new DAOTrackImpl(connection).findTrackByName(name);
            printer(track.getPerformer(), track.getName(), track.getDuration(), track.getGenre());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print all records of tracks from db, sorted by name A->Z.
     * */
    void sortByName() {
        try {
            trackList = daoFactory.getDAOTrackImpl(connection).getAll();
            trackList.sort(new TrackComparator());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Track track : trackList) {
            printer(track.getPerformer(), track.getName(), track.getDuration(), track.getGenre());
        }
    }

    /**
     * Find the longest song from db.
     * Print only one, if method finds tracks with equivalent duration.
     * */
    void findTheLongestSong() {
        try {
            Track track = daoFactory.getDAOTrackImpl(connection).getTheLongestTrack();
            printer(track.getPerformer(), track.getName(), track.getDuration(), track.getGenre());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
