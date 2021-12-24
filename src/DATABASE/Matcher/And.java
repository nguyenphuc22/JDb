package DATABASE.Matcher;

import java.util.ArrayList;

public class And implements Assert{

    private Assert a;
    private Assert b;

    public And(Assert a, Assert b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String getQuery() {
        return "(" + a.getQuery() + " AND " + b.getQuery() + ")";
    }
}
