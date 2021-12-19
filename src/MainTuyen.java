import DATABASE.Adapter;
import DATABASE.AdapterJDB;
import Entity.ColumnInfo;
import Entity.PrimaryKey;
import Entity.Table;
import Model.Animal;
import Model.User;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainTuyen {
    public static List<Field> getColumnFields(Class<?> type) {
        Field[] fields = type.getDeclaredFields();
        List<Field> columns = new ArrayList<>();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ColumnInfo.class)) {
                columns.add(field);
            }
        }

        Class<?> parentType = type.getSuperclass();
        if(parentType != null) {
            columns.addAll(getColumnFields(parentType));
        }

        return columns;
    }
    public static   <T>List<Field> getPrimaryKey(Class<T> type) {
        Field[] fields = type.getDeclaredFields();
        List<Field> primaries = new ArrayList<>();
        for (Field f : fields) {
            if (f.isAnnotationPresent(PrimaryKey.class)) {
                primaries.add(f);
            }
        }
        return primaries;
    }
    public static void main(String[] args) throws NoSuchFieldException {
        Adapter adapter = new AdapterJDB();
        System.out.println(adapter.convertTable(User.class));
        System.out.println(adapter.convertTable(Animal.class));
        Class<?> u = User.class;
        Annotation[] annotations = u.getAnnotations();
        // Lấy đối tượng Field


        Annotation[] fieldAnns = u.getAnnotations();

        for (Annotation methodAnn : fieldAnns) {
           System.out.println(u.getClass());

        }

        List<Field> columnFields = getPrimaryKey(User.class);
        String q="test";
        for(Field f:columnFields){
            Annotation a=f.getAnnotation(PrimaryKey.class);
            PrimaryKey p=(PrimaryKey) a;
            Class<?> type = f.getType();
            System.out.println(f.getName());
            System.out.println(p.name());
            if(p.name().equals("")){
                System.out.println(q+f.getName());
            }else
                System.out.println(q+p.name());
            Class<?> tmp=f.getType();


            System.out.println(f.getType().getName());
        }

    }
}
