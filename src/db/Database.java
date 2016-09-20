package db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static Connection connection;
    private static InitialContext initialContext;
    private static DataSource dataSource;

    public static Connection getConnection() {
        try {
            initialContext = new InitialContext();
            dataSource = (DataSource) initialContext.lookup("jdbc/Library");
            if (connection == null) {
                connection = dataSource.getConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return connection;
    }
}
