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
    public int id;

    @ColumnInfo(name= "name")
    public String name;

    @ColumnInfo(name="age")
    public String age;


}
