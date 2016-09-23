package db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {
    private static InitialContext initialContext;
    private static DataSource dataSource;

    public static DataSource getDataSource() {
        try {
            if (initialContext == null) initialContext = new InitialContext();
            if (dataSource == null) dataSource = (DataSource) initialContext.lookup("jdbc/Library");
        } catch (NamingException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dataSource;
    }
}
