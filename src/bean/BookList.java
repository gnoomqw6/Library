package bean;

import db.Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookList {
    private ArrayList<Book> bookArrayList = new ArrayList<>();

    private ArrayList<Book> getBooks() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM book");

            while (resultSet.next()) {
                Book book = new Book(resultSet.getString("name"), resultSet.getInt("page_count"),
                        resultSet.getString("isbn"), resultSet.getInt("genre_id"),
                        resultSet.getInt("author_id"), resultSet.getInt("publish_year"),
                        resultSet.getInt("publisher_id"));
                bookArrayList.add(book);
            }
        } catch (SQLException e) {
            Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                Logger.getLogger(BookList.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        return bookArrayList;
    }

    public ArrayList<Book> getBookArrayList() {
        if (bookArrayList.isEmpty()) {
            return getBooks();
        } else {
            return bookArrayList;
        }
    }
}
