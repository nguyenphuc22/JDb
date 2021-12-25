package DATABASE.Convert;

public abstract class FactoryTypeDB {
    public static final String TYPEDB_SQLITE = "SQLITE";
    public static final String TYPEDB_ORACLE = "ORACLE";

    public abstract ConvertTypeDB createDB(String ConvertTypeDB);
}
