package DATABASE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JSQLite implements JDBCLib{
    Connection conn = null;
    @Override
    public void connection(String url, Properties properties)  {
        String state = "jdbc:sqlite:";
        String resultURl = state.concat(url);
        System.out.println(resultURl);
        try {
            if (properties == null)
                conn = DriverManager.getConnection(resultURl);
            else
                conn = DriverManager.getConnection(resultURl,properties);

            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void executing(String query) {

    }
}
