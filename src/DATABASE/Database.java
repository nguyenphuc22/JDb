package DATABASE;


public interface Database {

    void open();
    void executing(String query);
    void createTable(Class<?> ... klass);
    void insert(Object ... objects);
    void delete(Object ... objects);
    void update(Object ... objects);
    void close();

}
