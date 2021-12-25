package DATABASE;

import Entity.ColumnInfo;
import Entity.PrimaryKey;
import Entity.Table;
import Model.Animal;
import Model.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapterJDB implements Adapter {
    // annotation
    // reflection java
    // https://www.javatpoint.com/java-annotation
    // https://kipalog.com/posts/Lam-sao-de-xay-dung-thu-vien-ORM?fbclid=IwAR3nX26rvt4Ogm86hD8nATlM2_6DAJsi6BsD5Oncl4WvjlRTq7U74-shMPw
    public  List<Field> getColumnInfos(Class<?> type) {
        Field[] fields = type.getDeclaredFields();
        List<Field> columns = new ArrayList<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(ColumnInfo.class)) {
                columns.add(f);
            }
        }
        return columns;
    }
    public  List<Field> getPrimaryKey(Class<?> type) {
        Field[] fields = type.getDeclaredFields();
        List<Field> primaries = new ArrayList<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(PrimaryKey.class)) {
                primaries.add(f);
            }
        }
        return primaries;
    }
    @Override
    public String convertQuery(Object object) {
        String table =null;
            HashMap<String, String> hashMap = new HashMap<String, String>();

            Field[] fields = object.getClass().getDeclaredFields();
            table = object.getClass().getAnnotation(Table.class).name();
            List<List<String>> columns = new ArrayList<>();
            for (Field f : fields) {
                if (f.isAnnotationPresent(PrimaryKey.class)) {
                    List<String>column1 = new ArrayList<>();
                    try {


                        hashMap.put(f.getName(),f.get(object).toString());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    column1.add(f.getAnnotation(PrimaryKey.class).name());
                    columns.add(column1);
                }

                if (f.isAnnotationPresent(ColumnInfo.class)) {
                    List<String>column1 = new ArrayList<>();

                    try {
                        hashMap.put(f.getName(),f.get(object).toString());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    column1.add(f.getAnnotation(ColumnInfo.class).name());
                    columns.add(column1);
                }
            }
            String insert ="INSERT INTO %s (%s) VALUES(%s)";
            String delete ="DELETE FROM %s WHERE %s = %s";
            
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {

                String.format(insert,table,entry.getKey(),hashMap.get(entry.getKey()));
            }
        // get annotation
        // get Table
        // get ColumnInfo
        //-------------
        // Cast object
        // Get value
        // Value
        // -------------
        // Example
        // Insert
        // INSERT INTO table (column1,column2 ,..) VALUES( value1,	value2 ,...);
        // User
        // INSERT INTO User  (name,age) VALUES ("Nick","123")
        //String insert = "";
        // Update
        String update = "";
        // Delete
       // String delete = "";
        return null;
    }

    @Override
    public String convertInsert(Object object) {
        String table;
        HashMap<String, String> column = new HashMap<>();
        HashMap<String, String> primarykey = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        table = object.getClass().getAnnotation(Table.class).name();
        List<List<String>> columns = new ArrayList<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(PrimaryKey.class)) {

                try {

                    primarykey.put(f.getAnnotation(PrimaryKey.class).name(),f.get(object).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }

            if (f.isAnnotationPresent(ColumnInfo.class)) {


                try {
                    column.put(f.getAnnotation(ColumnInfo.class).name(),f.get(object).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        String insert ="INSERT INTO %s (%s) VALUES (%s)";
        String col="";
        String value="";
        for (Map.Entry<String, String> entry : column.entrySet()) {


            col+=entry.getKey()+",";
            value+="'"+column.get(entry.getKey())+"' ,";

        }

        return String.format(insert,table,col.substring(0, col.length() - 1),value.substring(0, value.length() - 1));
    }

    @Override
    public String convertDelete(Object object) {
        String table;

        HashMap<String, String> primarykey = new HashMap<>();
        String primary = "";
        Field[] fields = object.getClass().getDeclaredFields();
        table = object.getClass().getAnnotation(Table.class).name();
        List<List<String>> columns = new ArrayList<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(PrimaryKey.class)) {

                try {
                    primary=f.getAnnotation(PrimaryKey.class).name();
                    primarykey.put(f.getAnnotation(PrimaryKey.class).name(),f.get(object).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }

        }
        String delete ="DELETE FROM %s WHERE %s";
        return String.format(delete,table,primary + " = "+ primarykey.get(primary));
    }

    @Override
    public String convertUpdate(Object object) {
        String table;
        String primary="";
        HashMap<String, String> column = new HashMap<>();
        HashMap<String, String> primarykey = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        table = object.getClass().getAnnotation(Table.class).name();
        List<List<String>> columns = new ArrayList<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(PrimaryKey.class)) {

                try {
                    primary=f.getAnnotation(PrimaryKey.class).name();
                    primarykey.put(f.getAnnotation(PrimaryKey.class).name(),f.get(object).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (f.isAnnotationPresent(ColumnInfo.class)) {
                try {
                    column.put(f.getAnnotation(ColumnInfo.class).name(),f.get(object).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
        String update ="UPDATE %s SET %s WHERE %s";
        String col="";
        String value="";
        for (Map.Entry<String, String> entry : column.entrySet()) {


            value+=entry.getKey()+ " = '" +column.get(entry.getKey())+ "'," ;

        }

        return String.format(update,table,value.substring(0, value.length() - 1),primary+" = "+ primarykey.get(primary));

    }

    @Override
    public String convertTable(Class<?> Klass) {
//        CREATE TABLE Persons (
//                PersonID int,
//                LastName varchar(255),
//                FirstName varchar(255),
//                Address varchar(255),
//                City varchar(255)
//        );
        /*List<Field> columnInfos = getColumnInfos(User.class);
        List<Field> primaries = getPrimaryKey(User.class);*/

        Field[] fieldsCol = Klass.getDeclaredFields();


        List<Field> columnInfos = new ArrayList<>();
        for (Field f : fieldsCol) {
            f.setAccessible(true);
            if (f.isAnnotationPresent(ColumnInfo.class)) {
                columnInfos.add(f);
            }
        }

        Field[] fieldsPri = Klass.getDeclaredFields();
        List<Field> primaries = new ArrayList<>();
        for (Field f : fieldsPri) {
            if (f.isAnnotationPresent(PrimaryKey.class)) {
                primaries.add(f);
            }
        }
        String query="CREATE TABLE ";

        Annotation ann = Klass.getAnnotation(Table.class);
        Table myAnn = (Table) ann;

        if(myAnn.name().equals("")){
            query=query+Klass.getClass()+" (";
        }else
            query=query+myAnn.name()+" (";

        for(Field f :primaries){
            Annotation a=f.getAnnotation(PrimaryKey.class);
            PrimaryKey p=(PrimaryKey) a;
            if(p.name().equals("")){
                query=query+f.getName().toString()+" ";
            }else
                query=query+p.name().toString()+" ";

            if(f.getType().getName().equals("java.lang.String")){
                query=query+"TEXT ";
            }
            else
                query=query+"INTEGER ";

            query=query+"PRIMARY KEY ";

            if(p.aotoincrement()==true){
                query=query+"AUTOINCREMENT,";
            }
            else
                query=query+",";
        }

        for(Field f :columnInfos){
            Annotation a=f.getAnnotation(ColumnInfo.class);
            ColumnInfo p=(ColumnInfo) a;
            if(p.name().equals("")){
                query=query+f.getName().toString()+" ";
            }else
                query=query+p.name().toString()+" ";

            if(f.getType().getName().equals("java.lang.String")){
                query=query+"TEXT ";
            }
            else
                query=query+"INTEGER ";

            if(p.notnull()==true){
                query=query+"NOT NULL,";
            }
            else
                query=query+",";
        }

        query=String.copyValueOf(query.toCharArray(), 0, query.length()-1);
        query=query+" );";
        return query;
    }

    @Override
    public String convertSelect(Class<?> Klass) {
        // Tuyen
        // SELECT * FROM table;
        Field[] fields = Klass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
        }
        Annotation ann = Klass.getAnnotation(Table.class);
        Table myAnn = (Table) ann;
        String query ="SELECT * FROM ";
        if(myAnn.name().equals("")){
            query=query+Klass.getClass()+" ;";
        }else
            query=query+myAnn.name()+" ;";

        return query;
    }
}
