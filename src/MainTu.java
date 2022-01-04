import DATABASE.Adapter;
import DATABASE.AdapterJDB;
import Entity.ColumnInfo;
import Model.Animal;
import Model.User;

public class MainTu {
    public static void main(String[] args) {
        User user = new User("Nick","123");
        Animal dog = new Animal("Tuyen",21,2);
        Adapter adapter = new AdapterJDB();
        System.out.println(adapter.convertUpdate(user));
        System.out.println((adapter.convertInsert(dog)));

    }
}
