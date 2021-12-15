package DATABASE;

public interface Adapter {
    String convertQuery(Object object);

    <T> String convertTable(Class<T> KLass);
}
