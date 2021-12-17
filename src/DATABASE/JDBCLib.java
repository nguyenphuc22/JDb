package DATABASE;

import java.util.Properties;

public interface JDBCLib {
    void connection(String url, Properties properties) ;
    void executing(String query);
}
