package DATABASE;

import java.util.Properties;

public class JDBInfo implements DatabaseInfo{
    private final String url;
    private Properties properties = null;

    public JDBInfo(String url, Properties properties) {
        this.url = url;
        this.properties = properties;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public Properties getProperties() {
        return properties;
    }

    public static class Builder {
        private String mUrl;
        private Properties mProperties;

        public Builder addProperties(Properties properties) {
            mProperties = properties;
            return this;
        }

        public Builder addUrl(String url) {
            mUrl = url;
            return this;
        }

        public JDBInfo build() {
            return new JDBInfo(mUrl,mProperties);
        }
    }
}
