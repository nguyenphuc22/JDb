package DATABASE;

import DATABASE.Service.JOracle;
import DATABASE.Service.JSQLite;
import DATABASE.Service.JService;

public abstract class JFactory {

    public final static String JService_SQLITE = "SQLITE";
    public final static String JService_ORACLE = "ORACLE";
    private JService jdbcLib;

    public JService getJService(String JService) {
        switch (JService) {
            case JService_SQLITE -> {
                jdbcLib = new JSQLite();
            }
            case JService_ORACLE -> {
                jdbcLib = new JOracle();
            }
            default -> throw new IllegalStateException("Unexpected value: " + JService);
        }
        return jdbcLib;
    }
}
