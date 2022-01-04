import DATABASE.*;

import Model.Animal;
import Model.UserAndAnimal;


public class Main {
    public static void main(String[] args) {
        JDB jdb = JDB.getInstance();
        DatabaseInfo databaseInfo = new JDBInfo.Builder()
                .addUrl("DBTest.db")
                .build();
        jdb.setDatabaseInfo(databaseInfo);
        jdb.get(Animal.class);
    }
}
