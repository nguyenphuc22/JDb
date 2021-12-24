package DATABASE.Matcher;

public interface Assert {
    String getQuery();

    class Util {
        protected static String convert(Object value) {
            if (value.getClass() == String.class) {
                 return "'" +value.toString() + "'";
            }
            return value.toString();
        }
    }
}
