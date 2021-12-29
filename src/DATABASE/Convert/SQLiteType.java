package DATABASE.Convert;

public class SQLiteType implements ConvertTypeDB{
    @Override
    public String toTypeDB(Class<?> KClass) {
        String type=KClass.getTypeName();

        switch (KClass.getTypeName()){
            case "float":
                return " REAL ";

            case "double":
                return " REAL ";

            case "long":
                return " INTEGER ";

            case "int":
                return " INTEGER ";

            case "java.lang.String":
                return " TEXT ";

            case "boolean":
                return " REAL ";

            default:
                return " TEXT ";

        }
    }
}
