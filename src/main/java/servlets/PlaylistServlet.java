package servlets;

import dao.implementations.DAOFactoryImpl;
import model.Track;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PlaylistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    public void service(HttpServletRequest request, HttpServletResponse response) {
        DAOFactoryImpl daoFactory = DAOFactoryImpl.getInstance();
        List<Track> tracks;
        try {
            Connection connection = daoFactory.getConnection();
            tracks = daoFactory.getDAOTrackImpl(connection).getAll();
            request.setAttribute("playlist", tracks);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("jsp/playlist.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException | ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
