package DATABASE;

public abstract class JFactory {

    public final static String JDBCLIB_SQLITE = "SQLITE";
    public final static String JDBCLIB_ORACLE = "ORACLE";
    private JDBCLib jdbcLib;

    public JDBCLib getJDBC(String JDBCLIB) {
        switch (JDBCLIB) {
            case JDBCLIB_SQLITE -> {
                jdbcLib = new JSQLite();
            }
            case JDBCLIB_ORACLE -> {
                jdbcLib = new JOracle();
            }
            default -> throw new IllegalStateException("Unexpected value: " + JDBCLIB);
        }
        return jdbcLib;
    }
}
