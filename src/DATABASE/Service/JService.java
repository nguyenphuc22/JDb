package DATABASE.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Properties;

public interface JService {
    void connection(String url, Properties properties) ;
    void executing(String query);
    ResultSet executingResult(String query);
    void close();
    boolean isOpen();
    boolean isClose();
}
