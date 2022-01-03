import DATABASE.*;
import DATABASE.Convert.FactoryJDB;
import DATABASE.Convert.FactoryTypeDB;
import DATABASE.Matcher.And;
import DATABASE.Matcher.Assert;
import DATABASE.Matcher.Equal;
import DATABASE.Matcher.Or;
import DATABASE.Service.JSQLite;
import Entity.ColumnInfo;
import Entity.JoinTable;
import Entity.Relationship;
import Model.Animal;
import Model.User;
import Model.UserAndAnimal;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        JDB jdb = JDB.getInstance();
        DatabaseInfo databaseInfo = new JDBInfo.Builder()
                .addUrl("DBTest.db")
                .build();
        jdb.setDatabaseInfo(databaseInfo);
        jdb.get(UserAndAnimal.class);
    }
}
