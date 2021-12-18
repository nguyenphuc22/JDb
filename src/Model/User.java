package Model;

import Entity.ColumnInfo;
import Entity.PrimaryKey;
import Entity.Table;

@Table
public class User {

    public User(String name, String age) {
        this.name = name;
        this.age = age;
    }
    @PrimaryKey
    public String name;

    @ColumnInfo
    public String age;
}
