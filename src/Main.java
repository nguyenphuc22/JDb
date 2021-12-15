import DATABASE.Database;
import DATABASE.JDB;
import Model.User;
import Model.UserDao;
import Query.Insert;
import org.sqlite.JDBC;

public class Main {
    public static void main(String[] args) {
        System.out.println(JDBC.class.getClass().toString());
        JDB jdb = JDB.getInstance();
        User userDao = new User("Name","Age");
        create(User.class);
    }

    private static <T> void create(Class<T> ... userClass) {
    }
}
