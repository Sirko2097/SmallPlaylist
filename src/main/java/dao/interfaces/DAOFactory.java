package dao.interfaces;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * Factory of objects for working with db
 * */
public interface DAOFactory {
    Connection getConnection() throws SQLException;

    DAOTrack getDAOTrackImpl(Connection connection);
}
