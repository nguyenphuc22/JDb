package DATABASE.Matcher;

public class Or implements Assert{

    private Assert a;
    private Assert b;

    public Or(Assert a, Assert b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String getQuery() {
        return "(" + a.getQuery() + " OR " + b.getQuery() + ")";
    }
}
