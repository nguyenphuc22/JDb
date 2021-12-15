package DATABASE;

import Entity.Table;

public interface Adapter {
    String convertQuery(Object object);

    <T> String convertTable(Class<T> Klass);
}
