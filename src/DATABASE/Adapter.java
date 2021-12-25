package DATABASE;

import Entity.Table;

public interface Adapter {
    String convertQuery(Object object);

    String convertInsert(Object object);

    String convertDelete(Object object);

    String convertUpdate(Object object);

    String convertTable(Class<?> Klass);

    String convertSelect(Class<?> Klass);

    String toTypeDB(Class<?> Klass);
}
