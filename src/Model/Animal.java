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
    public double age;
    @ColumnInfo(name ="type")
    public float type;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAge() {
        return age;
    }

    public float getType() {
        return type;
    }



    public Animal(){}

    public Animal(String name, double age, float type) {
        this.name = name;
        this.age = age;
        this.type = type;
    }
}
