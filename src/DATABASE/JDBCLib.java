package DATABASE;

import java.sql.Connection;
import java.util.Properties;

public interface JDBCLib {
    Connection connection(String url, Properties properties) ;
    void executing(String query);
}
