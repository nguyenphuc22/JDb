package DATABASE;


import Entity.Table;

import java.util.List;

public interface Database {

    void open();
    void executing(String query);
    void createTable(Class<?> ... klass);
    void insert(Object ... objects);
    void delete(Object ... objects);
    void update(Object ... objects);
    void close();
    <T> List<T> get(Class<T> kClass);

}
