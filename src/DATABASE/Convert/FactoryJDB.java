package DATABASE.Convert;

public class FactoryJDB extends FactoryTypeDB{
    @Override
    public ConvertTypeDB createDB(String TypeDB) {
        if (TypeDB.equals(TYPEDB_SQLITE)) {
            return new SQLiteType();
        }
        if (TypeDB.equals(TYPEDB_ORACLE)) {
            return new OracleType();
        }
        return new SQLiteType();
    }
}
