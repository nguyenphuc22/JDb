package DATABASE.Matcher;

public class GreaterThan implements Assert{
    private String table;
    private Object value;

    public GreaterThan(String table, Object value) {
        this.table = table;
        this.value = value;
    }

    @Override
    public String getQuery() {
        return table + ">" + Assert.Util.convert(value);
    }
}
