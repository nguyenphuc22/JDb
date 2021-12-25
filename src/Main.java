import DATABASE.*;
import DATABASE.Matcher.And;
import DATABASE.Matcher.Assert;
import DATABASE.Matcher.Equal;
import DATABASE.Matcher.Or;
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
        Assert abc = new Equal("name","abc");
        Assert xyz = new Equal("age","xyz");
        Assert or = new And(abc,xyz);
        for (User user : jdb.get(or,User.class)) {
            System.out.println(user.getAge());
        }
        jdb.close();
    }
}
