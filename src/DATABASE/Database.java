package DATABASE;


public interface Database {

    void open();
    void executing(String query);
    <T> void createTable(Class<T> ... klass);
    void insert(Object ... objects);
    void delete(Object ... objects);
    void update(Object ... objects);
    void close();

}
