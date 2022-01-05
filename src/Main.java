import DATABASE.*;

import DATABASE.Matcher.And;
import DATABASE.Matcher.Assert;
import DATABASE.Matcher.Equal;
import Model.Animal;
import Model.User;
import Model.UserAndAnimal;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        JDB jdb = JDB.getInstance();
        DatabaseInfo info = new JDBInfo.Builder()
                .addUrl("DBTest.db")
                .build();
        jdb.setDatabaseInfo(info);
        jdb.createTable(Animal.class);
    }
}
