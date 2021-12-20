import DATABASE.*;
import Model.Animal;
import Model.User;

import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        JDB jdb = JDB.getInstance();
        JDBInfo jdbInfo = new JDBInfo.Builder()
                .addUrl("DBTest.db")
                .build();
        jdb.setDatabaseInfo(jdbInfo);
        jdb.setJdbcLib(JFactory.JDBCLIB_SQLITE);
        jdb.open();
        jdb.createTable(User.class,Animal.class);
        jdb.close();
    }
}
