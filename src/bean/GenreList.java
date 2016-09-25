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
    private ArrayList<Genre> genreArrayList = new ArrayList<>();

    private void getGenres() {
        genreArrayList.add(new Genre("Все книги", 0));  //database haven't genre "all books" so we add it to list manually
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = null;
        try {
            connection = Database.getDataSource().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from genre ORDER BY name");
            while (resultSet.next()) {
                Genre genre = new Genre(resultSet.getString("name"), resultSet.getInt("id"));
                genreArrayList.add(genre);
            }

        } catch (SQLException ex) {
            Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (statement != null) statement.close();
                if (resultSet != null) resultSet.close();
                if (connection != null) connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(GenreList.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public ArrayList<Genre> getGenreList() {
        if (genreArrayList.isEmpty()) {
            getGenres();
        }
        return genreArrayList;
    }
}
