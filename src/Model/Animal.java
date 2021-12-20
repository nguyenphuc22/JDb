package Model;

import Entity.ColumnInfo;
import Entity.PrimaryKey;
import Entity.Table;

@Table(name = "Animal")
public class Animal{
    @PrimaryKey(name ="id")
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "age")
    public String age;
    @ColumnInfo(name ="type")
    public String type;

    public Animal(String name, String age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
}
