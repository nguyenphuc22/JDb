package DATABASE.Matcher;

public class Equal implements Assert{
    private String col;
    private Object value;

    public Equal(String col, Object value) {
        this.col = col;
        this.value = value;
    }

    @Override
    public String getQuery() {
        return col + "=" + Assert.Util.convert(value);
    }
}
