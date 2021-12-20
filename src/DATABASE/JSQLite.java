package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JSQLite implements JDBCLib{
    Connection conn = null;
    @Override
    public Connection connection(String url, Properties properties) {
        String state = "jdbc:sqlite:";
        String resultURl = state.concat(url);
        System.out.println(resultURl);
        try {
            if (properties == null)
                conn = DriverManager.getConnection(resultURl);
            else
                conn = DriverManager.getConnection(resultURl,properties);
            System.out.println("Connection to SQLite has been established.");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Override
    public void executing(String query) {

    }
}
