package DATABASE;


public interface Database {

    boolean open();
    void executing(String query);
    <T> void createTable(Class<T> ... klass);
    void close();

}
