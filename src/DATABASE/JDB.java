package DATABASE;

import DATABASE.Matcher.Assert;
import DATABASE.Service.JService;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDB implements Database {
    private String CHAR_WHERE = "where";

    private DatabaseInfo mDatabaseInfo;
    private static JDB instance;
    private Adapter adapter;
    private JService jService;
    private JFactory jFactory;

    public static JDB getInstance() {
        if (instance == null)
            instance = new JDB();
        return instance;
    }

    public JDB() {
        this.jFactory = new JFactoryDefault();
        jService = jFactory.getJService(JFactory.JService_SQLITE);
        setAdapter(new AdapterJDB());
    }

    @Override
    public void open() {
        if (!jService.isOpen())
            jService.connection(mDatabaseInfo.getUrl(),mDatabaseInfo.getProperties());
    }

    @Override
    public void executing(String query) {
        jService.executing(query);
    }
    @Override
    public void createTable(Class<?>... klass) {
        open();
        String query;
        for (Class<?> aClass : klass) {
            query = adapter.convertTable(aClass);
            executing(query);
        }
    }

    public void setDatabaseInfo(DatabaseInfo databaseInfo) {
        this.mDatabaseInfo = databaseInfo;
    }

    public void setJService(String JService) {
        jService = jFactory.getJService(JService);
    }

    @Override
    public void insert(Object ... objects) {
        open();
        String query;
        for (Object object : objects) {
            query = adapter.convertInsert(object);
            System.out.println(query);
            executing(query);
        }
    }
    @Override
    public void delete(Object ... objects) {
        open();
        String query;
        for (Object object : objects) {
            query = adapter.convertDelete(object);
            executing(query);
        }
    }

    @Override
    public void delete(Assert a, Object... objects) {
        open();
        String query;
        for (Object object : objects) {
            query = adapter.convertDelete(object);
            query = query.substring(0,query.toLowerCase().lastIndexOf(CHAR_WHERE) + 6);
            query = query.concat(a.getQuery());
            executing(query);
        }
    }

    @Override
    public void update(Object ... objects) {
        open();
        String query;
        for (Object object : objects) {
            query = adapter.convertUpdate(object);
            executing(query);
        }
    }

    public void setJFactory(JFactory jFactory) {
        this.jFactory = jFactory;
    }

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void close() {
        if (!jService.isClose())
            jService.close();
    }

    @Override
    public <T> List<T> get(Class<T> kClass) {
        String query = adapter.convertSelect(kClass);
        ResultSet resultSet = this.jService.executingResult(query);
        return createListObject(kClass,resultSet);
    }

    @Override
    public <T> List<T> get(Assert a, Class<T> kClass) {
        String query = adapter.convertSelect(kClass);
        query = query.concat(" ").concat(CHAR_WHERE).concat("").concat(a.getQuery());
        ResultSet resultSet = this.jService.executingResult(query);
        return createListObject(kClass,resultSet);
    }

    private <T> List<T> createListObject(Class<T> kClass,ResultSet resultSet) {
        // Tuyen
        // Create object using class
        List<Object> rs= new ArrayList<>();
        Field[] fields=kClass.getDeclaredFields();

        Annotation[] anns=kClass.getAnnotations();
        try {
            int index=1;
            Class<?> clazz = Class.forName(kClass.getName());
            Constructor<?> ctor = clazz.getConstructor(String.class);


            ResultSetMetaData rsmd = resultSet.getMetaData();
            while(resultSet.next()) {

                Object sa=resultSet.getObject(index);
                Object object = ctor.newInstance(new Object[] { sa });

                index++;
                rs.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        // https://stackoverflow.com/questions/6094575/creating-an-instance-using-the-class-name-and-calling-constructor
        return null;
    }

}
