package DATABASE;

import Entity.Table;

public interface Adapter {
    String convertQuery(Object object);

    String convertTable(Class<?> Klass);
}
