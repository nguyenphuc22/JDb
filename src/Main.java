import DATABASE.*;
import Model.Animal;
import Model.User;

import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        JDB jdb = JDB.getInstance();
        JDBInfo jdbInfo = new JDBInfo.Builder()
                .addUrl("DBTest.db")
                .build();
        jdb.setDatabaseInfo(jdbInfo);
        jdb.createTable(User.class,Animal.class);
        jdb.close();
        List<User> users = jdb.get(User.class);
    }
}
