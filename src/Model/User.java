package Model;

import Entity.ColumnInfo;
import Entity.PrimaryKey;
import Entity.Table;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Table(name="User")
public class User  {
    public  User(){}

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
    public User(int Id, String name,String age){
        this.name = name;
        this.age = age;
        this.id=Id;
    }
    @PrimaryKey(name="Id")
    private int id;

    @ColumnInfo(name= "name")
    private String name;

    @ColumnInfo(name="age")
    private String age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
