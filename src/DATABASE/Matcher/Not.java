package DATABASE.Matcher;

public class Not implements Assert{
    private Assert a;

    public Not(Assert a) {
        this.a = a;
    }

    @Override
    public String getQuery() {
        return " NOT " +"(" + a.getQuery() +")" ;
    }
}
