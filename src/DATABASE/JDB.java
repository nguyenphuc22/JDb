package DATABASE;

import java.sql.Connection;
import java.sql.SQLException;

public class JDB implements Database {
    private DatabaseInfo mDatabaseInfo;
    private static JDB instance;
    private Adapter adapter;
    private JDBCLib mJDBCLib;
    private Connection connection;
    private JFactory jFactory;

    public static JDB getInstance() {
        if (instance == null)
            instance = new JDB();
        return instance;
    }

    public JDB() {
        this.mJDBCLib = new JSQLite();
        this.adapter = new AdapterJDB();
        this.jFactory = new JFactoryDefault();
    }

    @Override
    public void open() {
        connection = mJDBCLib.connection(mDatabaseInfo.getUrl(),mDatabaseInfo.getProperties());
    }

    @Override
    public void executing(String query) {
        try {
            connection.createStatement().execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void createTable(Class<?>... klass) {
        String query;
        for (Class<?> aClass : klass) {
            query = adapter.convertTable(aClass);
            executing(query);
        }
    }

    public void setDatabaseInfo(DatabaseInfo databaseInfo) {
        this.mDatabaseInfo = databaseInfo;
    }

    public void setJdbcLib(String JDBCLIB) {
        mJDBCLib = jFactory.getJDBC(JDBCLIB);
    }

    @Override
    public void insert(Object ... objects) {
        String query;
        for (Object object : objects) {
            query = adapter.convertQuery(object);
            System.out.println(query);
            executing(query);
        }
    }
    @Override
    public void delete(Object ... objects) {
        String query = "";
        for (int i = 0; i < objects.length ; i++) {
            query = adapter.convertQuery(objects[i]);
        }
        executing(query);
    }
    @Override
    public void update(Object ... objects) {
        String query = "";
        for (int i = 0; i < objects.length ; i++) {
            query = adapter.convertQuery(objects[i]);
        }
        executing(query);
    }

    public void setJFactory(JFactory jFactory) {
        this.jFactory = jFactory;
    }

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
