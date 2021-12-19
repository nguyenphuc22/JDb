package Model;

import Entity.ColumnInfo;
import Entity.PrimaryKey;
import Entity.Table;

@Table(name = "asd")
public class Animal{
    @PrimaryKey(name ="name")
    String name;
    @ColumnInfo(name = "age",notnull = true)
    String age;
    @ColumnInfo(name ="type")
    String type;

    public Animal(String name, String age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
}
