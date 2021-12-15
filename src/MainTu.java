import DATABASE.Adapter;
import DATABASE.AdapterJDB;
import Model.Animal;
import Model.User;

public class MainTu {
    public static void main(String[] args) {
        Adapter adapter = new AdapterJDB();
        System.out.println(adapter.convertTable(User.class));
        System.out.println(adapter.convertTable(Animal.class));
    }
}
