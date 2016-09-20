package bean;

import db.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GenreList {
    private static ArrayList<Genre> genreArrayList = new ArrayList<Genre>();

    private static void getGenres() {
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = Database.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from genre ORDER BY name");
            while (resultSet.next()) {
                Genre genre = new Genre(resultSet.getString("name"));
                genreArrayList.add(genre);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) statement.close();
                if (resultSet != null)resultSet.close();
                if (connection != null)connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static ArrayList<Genre> getGenreList() {
        if (genreArrayList.isEmpty()) {
            getGenres();
        }
        return genreArrayList;
    }
}