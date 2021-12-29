import DATABASE.Adapter;
import DATABASE.AdapterJDB;
import DATABASE.Convert.SQLiteType;
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

       /* JDB jdb = JDB.getInstance();
        JDBInfo jdbInfo = new JDBInfo.Builder()
                .addUrl("DBTest.db")
                .build();
        jdb.setDatabaseInfo(jdbInfo);
        List<Animal> users=jdb.get(Animal.class);
        for (Animal u:users) {
            System.out.println(u.type.toString());

        }
        System.out.println(users.size());
        jdb.close();*/
        float fl= 5;
        double db=5.0;
        long a=5;
        boolean b=true;
        SQLiteType sqLiteType=new SQLiteType();
        AdapterJDB adap =new AdapterJDB();
        System.out.println(adap.convertTable(Animal.class));




    }
}
