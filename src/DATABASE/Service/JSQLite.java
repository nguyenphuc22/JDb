package DATABASE.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JSQLite implements JService {
    Connection conn = null;
    @Override
    public void connection(String url, Properties properties) {
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
        }
    }

    @Override
    public void executing(String query) {
        System.out.println(query);
        try {
            conn.createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet executingResult(String query) {
        ResultSet resultSet = null;
        try {
            resultSet = conn.createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    @Override
    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isOpen() {
        if (conn != null)
            return true;
        return false;
    }

    @Override
    public boolean isClose() {
        return isOpen();
    }
}
