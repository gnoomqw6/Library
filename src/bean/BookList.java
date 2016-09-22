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
    private ArrayList<Book> getBooks(String sqlRequest) {
        ArrayList<Book> bookList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlRequest);

            while (resultSet.next()) {
                Book book = new Book(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("page_count"),
                        resultSet.getString("isbn"), resultSet.getString("genre"),
                        resultSet.getString("fio"), resultSet.getInt("publish_year"),
                        resultSet.getString("publisher"), resultSet.getInt("image_number"));
                bookList.add(book);
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

        return bookList;
    }

    public ArrayList<Book> getBooksByGenre(int id) {
        return getBooks("select book.id, book.name, genre.name as genre," +
                "author.fio, page_count, publisher.name as publisher," +
                "publish_year, isbn, image_number from book" +
                "inner join author on book.author_id = author.id" +
                "inner join genre on book.genre_id = genre.id" +
                "inner join publisher on book.publisher_id = publisher.id" +
                "where genre_id = " + id + " order by book.name;");
    }
}
