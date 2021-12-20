package DATABASE;

import java.sql.Connection;
import java.util.Properties;

public interface JService {
    void connection(String url, Properties properties) ;
    void executing(String query);
    void close();
    boolean isOpen();
    boolean isClose();
}
