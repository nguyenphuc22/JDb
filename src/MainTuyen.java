import DATABASE.Adapter;
import DATABASE.AdapterJDB;
import DATABASE.JDB;
import DATABASE.JDBInfo;
import Entity.ColumnInfo;
import Entity.PrimaryKey;
import Entity.Table;
import Model.Animal;
import Model.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainTuyen {

    public static void main(String[] args) throws NoSuchFieldException {
        JDB jdb = JDB.getInstance();
        JDBInfo jdbInfo = new JDBInfo.Builder()
                .addUrl("DBTest.db")
                .build();
        jdb.setDatabaseInfo(jdbInfo);
        jdb.get(User.class);
        jdb.close();


    }
}
