package Model;

import Entity.ColumnInfo;
import Entity.PrimaryKey;
import Entity.Table;

@Table
public class Animal{
    @PrimaryKey
    private long id;
    @ColumnInfo
    private String name;
    @ColumnInfo
    private String type;
    @ColumnInfo
    private boolean sex;

    public Animal() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
