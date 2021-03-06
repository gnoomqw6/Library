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
    //the first part of search request. the second part depends from the request type and will be added in methods below
    private String partOfRequest = "select book.id, book.price, book.`name`, genre_id, genre.`name` as genre, " +
            "author.fio, page_count, publisher.`name` as publisher, " +
            "publish_year, isbn, image_number from book " +
            "inner join author on book.author_id = author.id " +
            "inner join genre on book.genre_id = genre.id " +
            "inner join publisher on book.publisher_id = publisher.id ";

    private ArrayList<Book> getBooks(String sqlRequest) {
        ArrayList<Book> bookList = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = Database.getDataSource().getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sqlRequest);

            while (resultSet.next()) {
                Book book = new Book(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getInt("price"), resultSet.getInt("page_count"),
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
        if (id == 0) {     //if user has clicked "all books"
            return getBooks(partOfRequest + "order by name");
        }
        return getBooks(partOfRequest + "where genre_id = " + id + " order by name;");
    }

    public ArrayList<Book> getBooksByLetter(String letter) {
        if (letter.equals("num")) {     //search by digit
            return getBooks(partOfRequest + "where book.name regexp '^[0-9].*' order by name;");
        } else {
            return getBooks(partOfRequest + "where book.name like '" + letter + "%' order by name;");
        }
    }

    public ArrayList<Book> getBooksByString(String str) {
        return getBooks(partOfRequest + "where book.name like '%" + str + "%' " +
                "or author.fio like '%" + str + "%' order by name;");
    }

    public ArrayList<Book> getNewBooks() {
        return getBooks(partOfRequest + "order by id desc limit 0,9;");
    }

    public ArrayList<Book> getPopularBooks() {
        //just simulate - I have no statistic yet
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            int id = (int) (Math.random() * 503) + 21;
            arr[i] = id;
        }
        return getBooks(partOfRequest + "where book.id in (" + arr[0] + ", " +
                arr[1] + ", " + arr[2] + ", " + arr[3] + ", " + arr[4] + ", " +
                arr[5] + ", " + arr[6] + ", " + arr[7] + ", " + arr[8] + ");");
    }

    public ArrayList<Book> getOnlineBooks() {
        return getBooks(partOfRequest + "where book.id in (521, 522, 523)");
    }
}
