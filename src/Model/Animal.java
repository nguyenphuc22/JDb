package Model;

import Entity.ColumnInfo;
import Entity.Table;

@Table
public class Animal {
    @ColumnInfo
    String name;
    @ColumnInfo
    String age;
    @ColumnInfo
    String type;

    public Animal(String name, String age, String type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
}
