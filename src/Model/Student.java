package Model;

import Entity.ColumnInfo;
import Entity.PrimaryKey;
import Entity.Table;

@Table(name="Student")
public class Student {
    @PrimaryKey(name ="id")
    public int id;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "Class")
    public String Class;

   public Student(){}
}
