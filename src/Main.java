import DATABASE.*;

import DATABASE.Matcher.Assert;
import DATABASE.Matcher.Equal;
import Model.Animal;
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
        List<Animal> animals = jdb.get(Animal.class);
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
