package DATABASE;


import DATABASE.Matcher.Assert;
import Entity.Table;

import java.util.List;

public interface Database {

    void open();
    void executing(String query);
    void createTable(Class<?> ... klass);
    void insert(Object ... objects);
    void delete(Object ... objects);
    void delete(Assert a, Object... objects);
    void update(Object ... objects);
    void close();
    <T> List<T> get(Class<T> kClass);
    <T> List<T> get(Assert a,Class<T> kClass);

}
