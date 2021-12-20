package DATABASE;

import DATABASE.Service.JSQLite;
import DATABASE.Service.JService;

public class JDB implements Database {
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
        this.jService = new JSQLite();
        this.adapter = new AdapterJDB();
        this.jFactory = new JFactoryDefault();
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
            query = adapter.convertQuery(object);
            System.out.println(query);
            executing(query);
        }
    }
    @Override
    public void delete(Object ... objects) {
        open();
        String query = "";
        for (int i = 0; i < objects.length ; i++) {
            query = adapter.convertQuery(objects[i]);
        }
        executing(query);
    }
    @Override
    public void update(Object ... objects) {
        open();
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
        if (!jService.isClose())
            jService.close();
    }
}
