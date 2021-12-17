import DATABASE.JDB;
import DATABASE.JDBInfo;
import DATABASE.JSQLite;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        JDB jdb = JDB.getInstance();
        JDBInfo jdbInfo = new JDBInfo.Builder()
                .addUrl("DBTest.db")
                .build();
        jdb.setDatabaseInfo(jdbInfo);
        jdb.setJdbcLib(new JSQLite());
        jdb.open();
    }
}
