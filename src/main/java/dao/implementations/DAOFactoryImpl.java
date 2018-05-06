package dao.implementations;

import dao.interfaces.DAOFactory;
import dao.interfaces.DAOTrack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactoryImpl implements DAOFactory {
    private String user = "root";
    private String password = "123789Cthusq";
    private String url = "jdbc:mysql://localhost:3306/musicLib";
    private String driver = "com.mysql.jdbc.Driver";

    private static DAOFactoryImpl instance = new DAOFactoryImpl();

    public static DAOFactoryImpl getInstance() {
        return instance;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public DAOTrack getDAOTrackImpl(Connection connection) {
        return new DAOTrackImpl(connection);
    }

    private DAOFactoryImpl() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
