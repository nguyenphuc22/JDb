package DATABASE;

import DATABASE.Convert.ConvertTypeDB;
import DATABASE.Convert.FactoryJDB;
import DATABASE.Convert.FactoryTypeDB;
import DATABASE.Convert.SQLiteType;
import Entity.*;
import Model.Animal;
import Model.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdapterJDB implements Adapter {

    ConvertTypeDB convertTypeDB;
    FactoryTypeDB factoryTypeDB;

    public AdapterJDB() {
        factoryTypeDB = new FactoryJDB();
        convertTypeDB = factoryTypeDB.createDB(FactoryJDB.TYPEDB_SQLITE);
    }


    @Override
    public String convertInsert(Object object) {
        String table;
        HashMap<String, String> column = new HashMap<>();
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
        }
        table = (object.getClass().getAnnotation(Table.class).name().equals("")) ? object.getClass().getSimpleName() : object.getClass().getAnnotation(Table.class).name();

        for (Field f : fields) {
            if (f.isAnnotationPresent(ColumnInfo.class)) {
                String field_name = (f.getAnnotation(ColumnInfo.class).name().equals(""))? f.getName(): f.getAnnotation(ColumnInfo.class).name();
                try {
                    column.put(field_name,f.get(object).toString());
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
        for (Field field : fields) {
            field.setAccessible(true);
        }
        table = (object.getClass().getAnnotation(Table.class).name().equals(""))?object.getClass().getSimpleName():object.getClass().getAnnotation(Table.class).name();

        for (Field f : fields) {
            if (f.isAnnotationPresent(PrimaryKey.class)) {
                String field_name = (f.getAnnotation(PrimaryKey.class).name().equals(""))? f.getName(): f.getAnnotation(PrimaryKey.class).name();
                try {
                    primary=field_name;
                    primarykey.put(field_name,f.get(object).toString());
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
        for (Field field : fields) {
            field.setAccessible(true);
        }
        table = (object.getClass().getAnnotation(Table.class).name().equals(""))?object.getClass().getSimpleName():object.getClass().getAnnotation(Table.class).name();

        for (Field f : fields) {
            if (f.isAnnotationPresent(PrimaryKey.class)) {
                String field_name = (f.getAnnotation(PrimaryKey.class).name().equals(""))? f.getName(): f.getAnnotation(PrimaryKey.class).name();
                try {
                    primary=field_name;
                    primarykey.put(field_name,f.get(object).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (f.isAnnotationPresent(ColumnInfo.class)) {
                String field_name = (f.getAnnotation(ColumnInfo.class).name().equals(""))? f.getName(): f.getAnnotation(ColumnInfo.class).name();
                try {
                    column.put(field_name,f.get(object).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        String update ="UPDATE %s SET %s WHERE %s";
        String value="";
        for (Map.Entry<String, String> entry : column.entrySet()) {
            value+=entry.getKey()+ " = '" +column.get(entry.getKey())+ "'," ;
        }

        return String.format(update,table,value.substring(0, value.length() - 1),primary+" = "+ primarykey.get(primary));

    }

    @Override
    public String convertTable(Class<?> Klass) {
        SQLiteType sqLiteType=new SQLiteType();
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

            // if(f.getType().getName().equals("java.lang.String")){
            //     query=query+"TEXT ";
            // }
            // else
            //     query=query+"INTEGER ";
            int.class.toString();
            System.out.println((f.getType()));
            query=query+sqLiteType.toTypeDB(f.getType());

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

           /* if(f.getType().getName().equals("java.lang.String")){
                query=query+"TEXT ";
            }
            else
                query=query+"INTEGER ";*/

            query=query+sqLiteType.toTypeDB(f.getType());

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
        String query = "SELECT * FROM ";

        Field[] fields = Klass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
        }
        Annotation ann = Klass.getAnnotation(Table.class);
        Table myAnn = (Table) ann;
        if (myAnn != null) {

            if (myAnn.name().equals("")) {
                query = query + Klass.getClass();
            } else {
                query = query + myAnn.name();
            }

        } else {
            for (Field field : fields) {
                if (field.getAnnotation(JoinTable.class) != null || field.getAnnotation(Relationship.class) != null ) {
                    query = query.concat(" ").concat(field.getName().concat(","));
                }
            }
            query = query.substring(0,query.length() - 1).concat(" ");
            query = query.concat("Where").concat(" ");
            for (Field field : fields) {
                if (field.getAnnotation(Relationship.class) != null) {
                    Annotation annotation = field.getAnnotation(Relationship.class);
                    Relationship relationship = (Relationship) annotation;
                    query = query.concat(relationship.name())
                            .concat(".")
                            .concat(relationship.joinColumns())
                            .concat(" ")
                            .concat("=")
                            .concat(" ")
                            .concat(field.getType().getSimpleName())
                            .concat(".")
                            .concat(relationship.inverseJoinColumns());
                }
            }
        }
        return query;
    }

}
