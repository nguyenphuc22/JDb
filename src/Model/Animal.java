package Model;

import Entity.ColumnInfo;
import Entity.PrimaryKey;
import Entity.Table;

@Table(name = "Animal")
public class Animal{
    @PrimaryKey(name ="id")
    int id;
    @ColumnInfo(name = "name")
    String name;
    @ColumnInfo(name = "age")
    String age;
    @ColumnInfo(name ="type")
    String type;

    public Animal(String name, String age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
}
