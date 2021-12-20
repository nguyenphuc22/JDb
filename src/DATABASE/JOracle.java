package DATABASE;

import java.sql.Connection;
import java.util.Properties;

public class JOracle implements JDBCLib{
    @Override
    public Connection connection(String url, Properties properties) {
        return null;
    }

    @Override
    public void executing(String query) {

    }
}
