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

    public User(String name, String age, Double abc, Boolean sex) {
        this.name = name;
        this.age = age;
    }

    public User(String name, String age, Double abc) {
        this.name = name;
        this.age = age;
    }

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
    public User(long Id, String name,String age){
        this.name = name;
        this.age = age;
        this.id=Id;
    }
    @PrimaryKey(name="id")
    private long id;

    @ColumnInfo(name= "name")
    private String name;

    @ColumnInfo(name="age")
    private String age;

    public long getId() {
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

    public void setId(long id) {
        this.id = id;
    }

}
