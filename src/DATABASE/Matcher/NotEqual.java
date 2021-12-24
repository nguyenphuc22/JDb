package DATABASE.Matcher;

public class NotEqual implements Assert{
    private String table;
    private Object value;

    public NotEqual(String table, Object value) {
        this.table = table;
        this.value = value;
    }

    @Override
    public String getQuery() {
        return table + "<>" + Assert.Util.convert(value);
    }
}
