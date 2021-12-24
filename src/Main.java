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
//        JDB jdb = JDB.getInstance();
//        JDBInfo jdbInfo = new JDBInfo.Builder()
//                .addUrl("DBTest.db")
//                .build();
//        jdb.setDatabaseInfo(jdbInfo);
//        jdb.createTable(User.class,Animal.class);
//        jdb.close();
//        List<User> users = jdb.get(User.class);
//        Assert a = new Or(new Equal("City","Berlin"),new Equal("City","Obama"));
//        System.out.println(new And(new Equal("Country","Germany"),a).getQuery());
        String url = "I'm nick seven where are you form";
        System.out.println(url.substring(0,url.lastIndexOf("where") + 5));
    }
}
