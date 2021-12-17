package DATABASE;

import Model.User;

public class JDB implements Database {
    private DatabaseInfo mDatabaseInfo;
    private static JDB instance;
    private Adapter adapter;
    private JDBCLib mJDBCLib;
    public static JDB getInstance() {
        if (instance == null)
            instance = new JDB();
        return instance;
    }

    @Override
    public void open() {
        mJDBCLib.connection(mDatabaseInfo.getUrl(),mDatabaseInfo.getProperties());
    }

    @Override
    public void executing(String query) {

    }

    @Override
    public <T> void createTable(Class<T> ... klass) {
        String query = "";
        for (int i = 0; i < klass.length ; i++) {
            query = adapter.convertTable(klass[i]);
        }
        executing(query);
    }

    public void setDatabaseInfo(DatabaseInfo databaseInfo) {
        this.mDatabaseInfo = databaseInfo;
    }

    public void setJdbcLib(JDBCLib jdbcLib) {
        mJDBCLib = jdbcLib;
    }

    @Override
    public void insert(Object ... objects) {
        String query = "";
        for (int i = 0; i < objects.length ; i++) {
            query = adapter.convertQuery(objects[i]);
        }
        executing(query);
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

    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void close() {

    }
}
