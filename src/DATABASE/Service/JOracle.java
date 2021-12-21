package DATABASE.Service;

import DATABASE.Service.JService;

import java.sql.ResultSet;
import java.util.Properties;

public class JOracle implements JService {

    @Override
    public void connection(String url, Properties properties) {

    }

    @Override
    public void executing(String query) {

    }

    @Override
    public ResultSet executingResult(String query) {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public boolean isOpen() {
        return false;
    }

    @Override
    public boolean isClose() {
        return false;
    }
}
